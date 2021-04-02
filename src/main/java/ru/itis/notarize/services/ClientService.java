package ru.itis.notarize.services;

import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.dto.FileDto;

import java.util.List;

public interface ClientService {
    ClientDto signUp(ClientDto clientDto);

    ClientDto edit(String username, ClientDto clientDto);

    ClientDto findByUsername(String username);

    List<ClientDto> findAll();

    List<FileDto> getAllFiles(Long userId);
}
