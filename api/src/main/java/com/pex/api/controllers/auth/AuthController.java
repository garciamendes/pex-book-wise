package com.pex.api.controllers.auth;
import com.pex.api.dtos.AuthDTO;
import com.pex.api.dtos.RegisterDTO;
import com.pex.api.dtos.ResponseLoginDTO;
import com.pex.api.dtos.ResponseMessageDTO;
import com.pex.api.entities.Account;
import com.pex.api.entities.Auth;
import com.pex.api.repositories.AuthRepository;
import com.pex.api.repositories.UserRepository;
import com.pex.api.services.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final AuthRepository authRepository;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authManager, UserRepository userRepository, AuthRepository authRepository, TokenService tokenService) {
        this.authManager = authManager;
        this.userRepository = userRepository;
        this.authRepository = authRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody @Validated AuthDTO authDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password());
        var auth = this.authManager.authenticate(usernamePassword);

        var token = this.tokenService.generateToken((Auth) auth.getPrincipal());

        return ResponseEntity.ok(new ResponseLoginDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseMessageDTO> register(@RequestBody @Validated RegisterDTO registerDTO) {
        if (this.authRepository.findByEmail(registerDTO.email()) != null) {
            return ResponseEntity.badRequest().body(new ResponseMessageDTO("Email already exists"));
        }

        if (!registerDTO.password().equals(registerDTO.confirmPassword())) {
            return ResponseEntity.badRequest().body(new ResponseMessageDTO("Passwords not match"));
        }

        String hashPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        this.createUserAndAuth(registerDTO.email(), hashPassword);
        return ResponseEntity.ok().build();
    }

    @Transactional
    protected void createUserAndAuth(String email, String password) {
        Account user = new Account();
        user.setName(email);
        this.userRepository.save(user);

        Auth auth = new Auth();
        auth.setEmail(email);
        auth.setPassword(password);
        auth.setAccount(user);
        this.authRepository.save(auth);
    }
}
