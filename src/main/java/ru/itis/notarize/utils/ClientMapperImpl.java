package ru.itis.notarize.utils;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.models.Client;
import ru.itis.notarize.models.Role;

@Component
@AllArgsConstructor
public class ClientMapperImpl implements ClientMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Client fromDto(ClientDto clientDto) {
        return new Client(
                clientDto.getUsername(),
                passwordEncoder.encode(clientDto.getPassword()),
                Role.ROLE_CLIENT,
                clientDto.getFullName(),
                clientDto.getCity(),
                clientDto.getAge()
        );
    }

    @Override
    public ClientDto toDto(Client client) {
        return new ClientDto(
                client.getUsername(),
                client.getPassword(),
                client.getFullName(),
                client.getCity(),
                client.getAge()
        );
    }
}
