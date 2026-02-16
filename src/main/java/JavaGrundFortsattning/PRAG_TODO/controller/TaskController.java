package JavaGrundFortsattning.PRAG_TODO.controller;

import JavaGrundFortsattning.PRAG_TODO.dto.TaskDto;
import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import JavaGrundFortsattning.PRAG_TODO.service.TaskService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Task> GetAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping()
    public ResponseEntity<?> createTask(@RequestBody TaskDto taskDto){
        try {
            Task task = taskService.createTask(taskDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kunde inte spara task i databasen: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ett oväntat fel uppstod: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editTask(@PathVariable Integer id,
                                      @RequestBody TaskDto taskDto){
        try{
            Task task = taskService.updateTask(id, taskDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);

        }
        catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kunde inte ändra task i databasen" + e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ett oväntat fel uppstod" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }

}
