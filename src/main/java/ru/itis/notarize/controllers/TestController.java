package ru.itis.notarize.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.notarize.models.User;
import ru.itis.notarize.repositories.UserRepository;

@Slf4j
@RestController
@AllArgsConstructor
public class TestController {

    private final UserRepository userRepository;

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> hello(@AuthenticationPrincipal String username) {
        return ResponseEntity.of(userRepository.findByUsername(username));
    }

    @GetMapping("/notary")
    @ResponseBody
    @PreAuthorize("hasRole('NOTARY')")
    public String notaryHello(@AuthenticationPrincipal String username) {
        log.info(username);
        log.info(userRepository.findByUsername(username).get().toString());
        return userRepository.findByUsername(username).orElse(null).toString();
    }
}
