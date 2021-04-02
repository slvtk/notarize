package ru.itis.notarize.utils;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.notarize.dto.NotaryDto;
import ru.itis.notarize.models.Notary;
import ru.itis.notarize.models.Role;

@Component
@AllArgsConstructor
public class NotaryMapperImpl implements NotaryMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Notary fromDto(NotaryDto notaryDto) {
        return new Notary(
                notaryDto.getUsername(),
                passwordEncoder.encode(notaryDto.getPassword()),
                Role.ROLE_NOTARY,
                notaryDto.getFullName(),
                notaryDto.getCity(),
                notaryDto.getCompanyName(),
                notaryDto.getDescription()
        );
    }
}
