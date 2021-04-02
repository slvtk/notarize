package ru.itis.notarize.utils;

import ru.itis.notarize.dto.FileDto;
import ru.itis.notarize.models.File;

public interface FileMapper {

    FileDto toDto(File file);

}
