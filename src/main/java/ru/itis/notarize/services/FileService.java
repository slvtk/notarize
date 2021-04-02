package ru.itis.notarize.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.notarize.dto.FileDto;

import java.io.IOException;
import java.util.List;

public interface FileService {

    FileDto upload(MultipartFile file, String username) throws IOException;

    List<FileDto> getAllFiles();

}
