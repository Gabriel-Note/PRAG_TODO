package JavaGrundFortsattning.PRAG_TODO.controller;

import JavaGrundFortsattning.PRAG_TODO.dto.LogInDto;
import JavaGrundFortsattning.PRAG_TODO.entity.LogIn;
import JavaGrundFortsattning.PRAG_TODO.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:3000")
public class LogInController {

    private final AuthService authService;

    public LogInController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody LogInDto dto) {
        authService.register(dto);
        return "User registered";
    }

    @PostMapping("/login")
    public LogIn login(@RequestBody LogInDto dto) {
        return authService.login(dto);
    }
}
