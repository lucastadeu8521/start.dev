package dev.start.api.controller;
import dev.start.api.domain.Users;
import dev.start.api.dto.LoginRequest;
import dev.start.api.dto.LoginResponse;
import dev.start.api.dto.RegisterRequest;
import dev.start.api.dto.TokenResponse;
import dev.start.api.repository.UserRepository;
import dev.start.api.service.AuthService;
import dev.start.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest req) {
        authService.register(req.getNome(), req.getEmail(), req.getSenha());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest req) {
        String token = authService.login(req.getEmail(), req.getSenha());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
