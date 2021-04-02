package ru.itis.notarize.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itis.notarize.models.FileStatus;

@Data
@AllArgsConstructor
public class FileDto {
    private String name;
    private String path;
    private FileStatus status;
}
