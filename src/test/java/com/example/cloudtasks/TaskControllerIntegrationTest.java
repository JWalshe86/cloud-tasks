package com.example.cloudtasks; // Ensure this matches the package structure

import com.example.cloudtasks.model.Task;
import com.example.cloudtasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testDeleteTask() throws Exception {
        // Create a task to be deleted
        Task task = new Task();
        task.setTitle("Task to be deleted");
        task.setDescription("This task will be deleted");
        task.setStatus("Pending");

        // Save the task in the repository
        Task savedTask = taskRepository.save(task);

        // Perform the delete operation using MockMvc
        mockMvc.perform(delete("/tasks/" + savedTask.getTaskId()))
                .andExpect(status().isNoContent());

        // Check that the task is no longer present
        mockMvc.perform(get("/tasks/" + savedTask.getTaskId()))
                .andExpect(status().isNotFound());
    }
}

