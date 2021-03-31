package ru.itis.notarize.controllers.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.notarize.models.User;
import ru.itis.notarize.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserRestController {

    private final UserRepository userRepository;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> profile(@AuthenticationPrincipal String username) {
    return ResponseEntity.of(userRepository.findByUsername(username));
    }
}
