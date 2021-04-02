package ru.itis.notarize.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.itis.notarize.dto.FileDto;
import ru.itis.notarize.models.File;

@Slf4j
@Component
public class FileMapperImpl implements FileMapper {
    @Override
    public FileDto toDto(File file) {

        return new FileDto(
                file.getName(),
                file.getPath(),
                file.getStatus()
        );

    }
}
