package JavaGrundFortsattning.PRAG_TODO.dto;

public class TaskDto {
    private String description;

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

}
