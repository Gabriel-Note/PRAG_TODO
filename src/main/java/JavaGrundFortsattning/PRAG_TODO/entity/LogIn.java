package JavaGrundFortsattning.PRAG_TODO.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")

public class LogIn {
    @Id
    @GeneratedValue()
    private Long id;

    private String username;

    private String password;

}
