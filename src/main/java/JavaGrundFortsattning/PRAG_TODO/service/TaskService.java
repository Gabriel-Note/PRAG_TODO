package JavaGrundFortsattning.PRAG_TODO.service;

import JavaGrundFortsattning.PRAG_TODO.dto.TaskDto;
import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import JavaGrundFortsattning.PRAG_TODO.entity.TaskList;
import JavaGrundFortsattning.PRAG_TODO.repository.TaskRepository;
import JavaGrundFortsattning.PRAG_TODO.repository.TasklistRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TasklistRepository tasklistRepository;

    public TaskService(TaskRepository taskRepository, TasklistRepository tasklistRepository) {
        this.taskRepository = taskRepository;
        this.tasklistRepository = tasklistRepository;
    }

    public List<TaskDto> getAllTasks(){
        List<Task> allTasks = taskRepository.findAll();
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (Task task : allTasks){
            TaskDto taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setDescription(task.getDescription());
            taskDto.setCompleted(task.isCompleted());
            taskDto.setPoints(task.getPoints());
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
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
        task.setPoints(taskDto.getPoints());

        TaskList taskList = tasklistRepository.findById(taskDto.getTaskListId()).
                orElseThrow(() -> new RuntimeException("List not found"));
        task.setTaskList(taskList);

        return taskRepository.save(task);
    }

    public Task updateTask(int id, TaskDto taskDto){
        String taskDescription = taskDto.getDescription();

        Task task = getTaskById(id);
        task.setDescription(taskDescription);
        task.setPoints(taskDto.getPoints());
        return taskRepository.save(task);
    }

    public Task makeCompletedOrNotCompleted(int id) {
            Task task = getTaskById(id);
            if (task.isCompleted()){
                task.setCompleted(false);
            }
            else{
                task.setCompleted(true);
            }
            return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
