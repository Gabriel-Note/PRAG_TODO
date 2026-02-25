package JavaGrundFortsattning.PRAG_TODO.repository;

import JavaGrundFortsattning.PRAG_TODO.entity.LogIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInRepository extends JpaRepository<LogIn, Long> {
    LogIn findByUsername(String username);
}
