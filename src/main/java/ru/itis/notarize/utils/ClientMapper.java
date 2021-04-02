package ru.itis.notarize.utils;

import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.models.Client;

public interface ClientMapper {
    Client fromDto(ClientDto clientDto);

    ClientDto toDto(Client client);
}
