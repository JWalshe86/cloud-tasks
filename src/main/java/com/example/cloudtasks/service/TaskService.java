package com.example.cloudtasks.service; // Correct package declaration

import com.example.cloudtasks.exception.TaskNotFoundException; // Ensure this import is correct
import com.example.cloudtasks.model.Task; // Ensure this import is correct
import com.example.cloudtasks.repository.TaskRepository; // Ensure this import is correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime; // Ensure this import is correct
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository; // Inject the TaskRepository

    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now()); // Set the createdAt field
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setUpdatedAt(LocalDateTime.now()); // Set the updatedAt field
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.deleteById(id);
    }
}

