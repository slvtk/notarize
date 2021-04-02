package ru.itis.notarize.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.dto.FileDto;
import ru.itis.notarize.models.Client;
import ru.itis.notarize.repositories.ClientRepository;
import ru.itis.notarize.utils.ClientMapper;
import ru.itis.notarize.utils.FileMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final FileMapper fileMapper;

    @Override
    public ClientDto signUp(ClientDto clientDTO) {
        if (clientRepository.findByUsername(clientDTO.getUsername()).isPresent()) {
            throw new RuntimeException("User already exist");
        }
        return clientMapper.toDto(clientRepository.save(clientMapper.fromDto(clientDTO)));
    }

    @Override
    public ClientDto edit(String username, ClientDto clientDto) {
        Optional<Client> clientOpt = clientRepository.findByUsername(username);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            if (clientDto.getFullName() != null) {
                client.setFullName(clientDto.getFullName());
            }
            if (clientDto.getCity() != null) {
                client.setCity(clientDto.getCity());
            }
            if (clientDto.getAge() != null) {
                client.setAge(clientDto.getAge());
            }
            return clientMapper.toDto(clientRepository.save(client));
        }
        throw new EntityNotFoundException();
    }

    @Override
    public ClientDto findByUsername(String username) {
        Optional<Client> clientOpt = clientRepository.findByUsername(username);
        if (clientOpt.isPresent()) {
            return clientMapper.toDto(clientOpt.get());
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream().map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FileDto> getAllFiles(Long userId) {
        Optional<Client> clientOpt = clientRepository.findById(userId);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            //TODO: Возвращать CreationTimestamp
            return client.getFiles().stream()
                    .map(fileMapper::toDto)
                    .collect(Collectors.toList());
        }
        throw new EntityNotFoundException();
    }
}
