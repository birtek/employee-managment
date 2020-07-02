package pl.szydlowski.springbootcrudapi.service;

import pl.szydlowski.springbootcrudapi.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
    Task getSingleTask(int id);
}
