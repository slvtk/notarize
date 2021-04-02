package ru.itis.notarize.services;

import ru.itis.notarize.dto.NotaryDto;
import ru.itis.notarize.models.Notary;

public interface NotaryService {
    Notary signUp(NotaryDto notaryDto);
}
