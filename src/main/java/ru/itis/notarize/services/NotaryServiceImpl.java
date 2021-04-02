package ru.itis.notarize.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.notarize.dto.NotaryDto;
import ru.itis.notarize.models.Notary;
import ru.itis.notarize.repositories.NotaryRepository;
import ru.itis.notarize.repositories.UserRepository;
import ru.itis.notarize.utils.NotaryMapper;

@Service
@AllArgsConstructor
public class NotaryServiceImpl implements NotaryService {
    private final NotaryRepository notaryRepository;
    private final UserRepository userRepository;
    private final NotaryMapper notaryMapper;

    @Override
    public Notary signUp(NotaryDto notaryDto) {
        if (userRepository.findByUsername(notaryDto.getUsername()).isPresent()) {
            throw new RuntimeException("User already exist");
        }
        return notaryRepository.save(notaryMapper.fromDto(notaryDto));
    }
}
