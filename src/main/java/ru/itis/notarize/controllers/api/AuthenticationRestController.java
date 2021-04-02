package ru.itis.notarize.controllers.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.dto.NotaryDto;
import ru.itis.notarize.models.Notary;
import ru.itis.notarize.services.ClientService;
import ru.itis.notarize.services.NotaryService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth/")
public class AuthenticationRestController {

    private final ClientService clientService;
    private final NotaryService notaryService;

    @PostMapping("clients/signup")
    public ClientDto clientSignUp(@RequestBody ClientDto clientDto) {
        return clientService.signUp(clientDto);
    }

    @PostMapping("notaries/signup")
    public ResponseEntity<Notary> notarySignUp(@RequestBody NotaryDto notaryDto) {
        return ResponseEntity.ok(notaryService.signUp(notaryDto));
    }
}
