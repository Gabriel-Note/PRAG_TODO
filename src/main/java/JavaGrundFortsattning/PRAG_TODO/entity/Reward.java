package JavaGrundFortsattning.PRAG_TODO.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reward")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private int pointsNeeded;


    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public Integer getPointsNeeded() {return pointsNeeded;}

    public void setPointsNeeded(Integer pointsNeeded) {this.pointsNeeded = pointsNeeded;}
}
