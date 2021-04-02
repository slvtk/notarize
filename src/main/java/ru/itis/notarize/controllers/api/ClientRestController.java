package ru.itis.notarize.controllers.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.itis.notarize.dto.ClientDto;
import ru.itis.notarize.dto.FileDto;
import ru.itis.notarize.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@AllArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('CLIENT')")
    public ClientDto profile(@AuthenticationPrincipal String username) {
        return clientService.findByUsername(username);
    }

    @PatchMapping
    public ResponseEntity<ClientDto> editClient(@AuthenticationPrincipal String username,
                                        @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.edit(username, clientDto));
    }

    @GetMapping
    public List<ClientDto> clients(){
        return clientService.findAll();
    }

    @GetMapping("/{userId}/files")
    public List<FileDto> getDocumentList(@PathVariable Long userId){
        return clientService.getAllFiles(userId);
    }
}
