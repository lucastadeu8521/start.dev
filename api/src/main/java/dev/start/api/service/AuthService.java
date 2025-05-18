package dev.start.api.service;

import dev.start.api.domain.Users;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final TokenService tokenService;

    public AuthService(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public void register(String nome, String email, String senha) {
        userService.registerUser(nome, email, senha, "USER");
    }

    public String login(String email, String senha) {
        Users user = userService.findByEmail(email);

        if (!userService.validatePassword(user, senha)) {
            throw new RuntimeException("Senha incorreta");
        }

        return tokenService.generateToken(email);
    }
}