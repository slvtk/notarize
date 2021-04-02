package ru.itis.notarize.controllers.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.notarize.dto.FileDto;
import ru.itis.notarize.services.FileService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class FileRestController {

    private final FileService fileService;

    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public FileDto fileUpload(MultipartFile multipartFile,
                                  @AuthenticationPrincipal String username) throws IOException {
        return fileService.upload(multipartFile, username);
    }

    @GetMapping
    public List<FileDto> getFiles(){
        return fileService.getAllFiles();
    }

}
