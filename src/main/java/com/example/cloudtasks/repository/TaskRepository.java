package com.example.cloudtasks.repository;

import com.example.cloudtasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Custom query methods (if needed)
}

