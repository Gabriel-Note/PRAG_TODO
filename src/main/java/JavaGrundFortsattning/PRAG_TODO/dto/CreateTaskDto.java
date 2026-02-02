package JavaGrundFortsattning.PRAG_TODO.dto;

public class CreateTaskDto {
    private String name;

    public CreateTaskDto() {
    }

    public CreateTaskDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}