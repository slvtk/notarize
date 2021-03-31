package ru.itis.notarize.utils;

import ru.itis.notarize.dto.NotaryDto;
import ru.itis.notarize.models.Notary;

public interface NotaryMapper {
    Notary fromDto(NotaryDto notaryDto);
}
