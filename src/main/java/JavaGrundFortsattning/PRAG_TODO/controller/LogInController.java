package JavaGrundFortsattning.PRAG_TODO.controller;

import JavaGrundFortsattning.PRAG_TODO.dto.LogInDto;
import JavaGrundFortsattning.PRAG_TODO.entity.LogIn;
import JavaGrundFortsattning.PRAG_TODO.service.LogInService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LogInController {

    private final LogInService logInService;

    public LogInController(LogInService logInService) {
        this.logInService = logInService;
    }

    @PostMapping("/register")
    public String register(@RequestBody LogInDto dto) {
        logInService.register(dto);
        return "User registered";
    }

    @PostMapping("/login")
    public LogIn login(@RequestBody LogInDto dto) {
        return logInService.login(dto);
    }
}
