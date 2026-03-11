package JavaGrundFortsattning.PRAG_TODO.dto;

public class TaskDto {
    private Integer id;
    private String description;
    private boolean completed;
    private Integer points;

    public TaskDto() {
    }

    public TaskDto(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPoints() {return points;}

    public void setPoints(int points){ this.points = points;}
}
