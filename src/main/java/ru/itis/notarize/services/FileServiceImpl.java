package ru.itis.notarize.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.notarize.dto.FileDto;
import ru.itis.notarize.models.File;
import ru.itis.notarize.models.FileStatus;
import ru.itis.notarize.models.User;
import ru.itis.notarize.repositories.FileRepository;
import ru.itis.notarize.repositories.UserRepository;
import ru.itis.notarize.utils.FileMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    private final UserRepository userRepository;
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    @Value("${yaml.uploadDir}")
    private String UPLOAD_DIR;

    public FileServiceImpl(UserRepository userRepository,
                           FileRepository fileRepository,
                           FileMapper fileMapper) {
        this.userRepository = userRepository;
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
    }

    @Override
    public FileDto upload(MultipartFile multipartFile, String username) throws IOException {
        String encodedFileName = UUID.randomUUID().toString();
        Path path = Paths.get(UPLOAD_DIR, encodedFileName +
                multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf(".")));
        Files.write(path, multipartFile.getBytes());
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            File file = new File(multipartFile.getOriginalFilename(), "/uploads/" + path.getFileName().toString(), FileStatus.NOT_NOTARIZED);
            user.getFiles().add(file);
            userRepository.save(user);
            return fileMapper.toDto(file);
        } else {
            throw new IOException();
        }
    }

    @Override
    public List<FileDto> getAllFiles() {
        return fileRepository.findAll().stream()
                .map(fileMapper::toDto)
                .collect(Collectors.toList());
    }
}

