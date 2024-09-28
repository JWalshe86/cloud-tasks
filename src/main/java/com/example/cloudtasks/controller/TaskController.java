package com.example.cloudtasks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; // Import for @Autowired
import org.springframework.data.domain.Page; // For pagination support
import org.springframework.data.domain.Pageable; // For Pageable parameter
import org.springframework.data.domain.PageRequest; // For creating a PageRequest
import org.springframework.http.HttpStatus; // For HttpStatus
import org.springframework.http.ResponseEntity; // For ResponseEntity
import org.springframework.validation.annotation.Validated; // For @Validated
import org.springframework.web.bind.annotation.*; // For REST annotations
import com.example.cloudtasks.model.Task; // Import your Task model
import com.example.cloudtasks.service.TaskService; // Import your Task service

import jakarta.validation.Valid; // Import for @Valid

@RestController
@RequestMapping("/tasks")
@Validated // To enable validation
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService; // Inject the TaskService

    // Create Task
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        logger.debug("Received request to create task: {}", task);
        Task createdTask = taskService.createTask(task);
        logger.debug("Created task: {}", createdTask);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // Get All Tasks with Pagination
    @GetMapping
    public ResponseEntity<Page<Task>> getAllTasks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {

        logger.debug("Received request to get all tasks with page: {} and size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<Task> tasksPage = taskService.getAllTasks(pageable);
        logger.debug("Retrieved {} tasks", tasksPage.getTotalElements());
        return new ResponseEntity<>(tasksPage, HttpStatus.OK);
    }

    // Update Task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        logger.debug("Received request to update task with id: {} and details: {}", id, taskDetails);
        Task updatedTask = taskService.updateTask(id, taskDetails);
        logger.debug("Updated task: {}", updatedTask);
        return ResponseEntity.ok(updatedTask);
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        logger.debug("Received request to delete task with id: {}", id);
        taskService.deleteTask(id);
        logger.debug("Deleted task with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}

