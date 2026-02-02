package JavaGrundFortsattning.PRAG_TODO.service;

import JavaGrundFortsattning.PRAG_TODO.dto.CreateTaskDto;
import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import JavaGrundFortsattning.PRAG_TODO.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        List<Task> allTasks = taskRepository.findAll();
        int counter = 0;
        for (Task x : allTasks){
            System.out.println(counter + ": " + x.getTask());
            counter ++;
        }
        return allTasks;
    }

    public Task createTask(CreateTaskDto createTaskDto){

        Task task = new Task();
        task.setTask(createTaskDto.getName());

        return taskRepository.save(task);
    }
}
