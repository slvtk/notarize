package ru.itis.notarize.services;

import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.models.Client;

public interface ClientService {
    Client signUp(ClientDto clientDto);
}
