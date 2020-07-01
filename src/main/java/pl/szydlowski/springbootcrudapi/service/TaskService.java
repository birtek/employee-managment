package pl.szydlowski.springbootcrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szydlowski.springbootcrudapi.model.Task;
import pl.szydlowski.springbootcrudapi.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getSingleTask(int id) {
        return taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Task not found"));
    }
}
