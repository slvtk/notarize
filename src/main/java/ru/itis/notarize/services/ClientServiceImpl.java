package ru.itis.notarize.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.models.Client;
import ru.itis.notarize.repositories.ClientRepository;
import ru.itis.notarize.repositories.UserRepository;
import ru.itis.notarize.utils.ClientMapper;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    UserRepository userRepository;
    ClientMapper clientMapper;

    @Override
    public Client signUp(ClientDto clientDTO) {
        if (userRepository.findByUsername(clientDTO.getUsername()).isPresent()) {
            throw new RuntimeException("User already exist");
        }
        return clientRepository.save(clientMapper.fromDto(clientDTO));
    }
}
