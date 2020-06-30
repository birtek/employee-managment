package pl.szydlowski.springbootcrudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szydlowski.springbootcrudapi.model.Task;
import pl.szydlowski.springbootcrudapi.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/Tasks")
    public List<Task> getAllTask(){
        return taskService.getTasks();
    }

    @GetMapping("/Task/{id}")
    public Task getTask(@PathVariable int id){
        return taskService.getSingleTask(id);
    }

}
