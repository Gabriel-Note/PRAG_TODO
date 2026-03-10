package JavaGrundFortsattning.PRAG_TODO.service;

import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import JavaGrundFortsattning.PRAG_TODO.entity.TaskList;
import JavaGrundFortsattning.PRAG_TODO.repository.TasklistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskListService {

    private final TasklistRepository tasklistRepository;

    public TaskListService(TasklistRepository tasklistRepository) {
        this.tasklistRepository = tasklistRepository;
    }

    public List<TaskList> getAllTaskLists() {
        return tasklistRepository.findAll();
    }

    public TaskList createTaskList(String name){
        TaskList taskList = new TaskList();
        taskList.setName(name);
        return  tasklistRepository.save(taskList);
    }

    public TaskList renameTaskList(int id, String newName){
        TaskList taskList = getTaskListById(id);
        taskList.setName(newName);
        return tasklistRepository.save(taskList);
    }

    public TaskList getTaskListById(int id) {
        Optional<TaskList> optional = tasklistRepository.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }
    }

    public void deleteTaskList(int id) {
        tasklistRepository.deleteById(id);
    }

    public List<Task> getTasksByListId(int id) {
        TaskList taskList = getTaskListById(id);
        return taskList.getTasks();
    }
}
