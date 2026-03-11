package JavaGrundFortsattning.PRAG_TODO.controller;

import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import JavaGrundFortsattning.PRAG_TODO.entity.TaskList;
import JavaGrundFortsattning.PRAG_TODO.service.TaskListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasklists")
@CrossOrigin(origins="http://localhost:3000")
public class TaskListController {

    private final TaskListService taskListService;
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    public List<TaskList> getAllTaskList() {
        return taskListService.getAllTaskLists();
    }

    @PostMapping
    public ResponseEntity<?> createTaskList(@RequestBody String name) {
        try {
            TaskList taskList = taskListService.createTaskList(name);
            return ResponseEntity.status(HttpStatus.CREATED).body(taskList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ett oväntat fel uppstod"+e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> renameTaskList(@PathVariable int id, @RequestBody String newName) {
        try {
            TaskList taskList = taskListService.renameTaskList(id, newName);
            return ResponseEntity.ok(taskList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ett oväntat fel uppstod" +e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskList(@PathVariable int id) {
        try {
            taskListService.deleteTaskList(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ett oväntat fel uppstod"+e.getMessage());
        }
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<?> getTasksByList(@PathVariable int id) {
        try {
            List<Task> tasks = taskListService.getTasksByListId(id);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ett oväntat fel uppstod: " + e.getMessage());
        }
    }

}
