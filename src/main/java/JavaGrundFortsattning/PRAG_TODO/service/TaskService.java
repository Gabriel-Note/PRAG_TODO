package JavaGrundFortsattning.PRAG_TODO.service;

import JavaGrundFortsattning.PRAG_TODO.dto.TaskDto;
import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import JavaGrundFortsattning.PRAG_TODO.repository.TaskRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            System.out.println(counter + ": " + x.getDescription());
            counter ++;
        }
        return allTasks;
    }

    public Task getTaskById(int id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()){
            return optionalTask.get();
        }
        else {
            throw new RuntimeException("Task not found with id: " +id);
        }
    }

    public Task createTask(TaskDto taskDto){

        Task task = new Task();
        task.setDescription(taskDto.getDescription());

        return taskRepository.save(task);
    }

    public Task updateTask(int id, TaskDto taskDto){
        String taskDescription = taskDto.getDescription();

        Task task = getTaskById(id);
        task.setDescription(taskDescription);
        return taskRepository.save(task);
    }
}
