package com.example.cloudtasks.model; // Only one package declaration

import jakarta.persistence.*; // Update to jakarta for JPA annotations
import jakarta.validation.constraints.*; // Update to jakarta for validation annotations
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank(message = "Title cannot be blank") // Ensures title is not empty
    private String title;

    @Size(max = 500, message = "Description cannot exceed 500 characters") // Limits the description length
    private String description;

    @NotBlank(message = "Status cannot be blank") // Ensures status is not empty
    private String status; // e.g., Pending, Completed

    private LocalDate dueDate; // New field for the task's due date
    private String priority; // New field for the task's priority

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate; // Getter for the due date
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate; // Setter for the due date
    }

    public String getPriority() {
        return priority; // Getter for the priority
    }

    public void setPriority(String priority) {
        this.priority = priority; // Setter for the priority
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Add this method to get the ID
    public Long getId() {
        return taskId; // Provides a getter for taskId as 'getId()' method
    }
}

