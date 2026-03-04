package JavaGrundFortsattning.PRAG_TODO.service;

import JavaGrundFortsattning.PRAG_TODO.dto.LogInDto;
import JavaGrundFortsattning.PRAG_TODO.entity.LogIn;
import JavaGrundFortsattning.PRAG_TODO.repository.LogInRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final LogInRepository logInRepository;

    public AuthService(LogInRepository logInRepository) {
        this.logInRepository = logInRepository;
    }

    public void register(LogInDto dto) {
        if (dto.getPassword().length() < 4) {
            throw new RuntimeException("Password too short");
        }

        LogIn existingUser = logInRepository.findByUsername(dto.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }

        LogIn user = new LogIn();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        logInRepository.save(user);
    }

    public LogIn login(LogInDto dto) {
        LogIn user = logInRepository.findByUsername(dto.getUsername());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!(dto.getPassword().matches( user.getPassword()))) {
            throw new RuntimeException("Wrong password");
        }

        return user;
    }
}