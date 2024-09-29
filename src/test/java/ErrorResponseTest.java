package com.example.cloudtasks; // Ensure this matches your project structure

import org.junit.jupiter.api.Test; // Importing JUnit's Test annotation
import java.util.List; // Importing List
import java.util.Collections; // Importing Collections
import static org.junit.jupiter.api.Assertions.assertEquals; // Importing assertEquals
import static org.junit.jupiter.api.Assertions.assertNotNull; // Importing assertNotNull

public class ErrorResponseTest {

    @Test
    public void testErrorResponseConstructor() {
        String expectedMessage = "Task Not Found";
        List<String> expectedDetails = Collections.singletonList("No task found with the given ID.");
        
        // Create an instance of ErrorResponse
        ErrorResponse errorResponse = new ErrorResponse(expectedMessage, expectedDetails);
        
        // Test that the values are set correctly
        assertEquals(expectedMessage, errorResponse.getMessage());
        assertEquals(expectedDetails, errorResponse.getDetails());
    }

    @Test
    public void testErrorResponseTimestamp() {
        String expectedMessage = "Validation Failed";
        List<String> expectedDetails = Collections.singletonList("Field cannot be empty.");
        
        ErrorResponse errorResponse = new ErrorResponse(expectedMessage, expectedDetails);
        
        // Check if the timestamp is not null
        assertNotNull(errorResponse.getTimestamp());
    }
}

