package JavaGrundFortsattning.PRAG_TODO.dto;

public class TaskDto {
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
