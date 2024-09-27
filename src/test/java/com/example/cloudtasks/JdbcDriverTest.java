package com.example.cloudtasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JdbcDriverTest {

    @Test
    public void testDriverLoading() {
        try {
            Class<?> driverClass = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            assertNotNull(driverClass, "Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load driver: com.microsoft.sqlserver.jdbc.SQLServerDriver", e);
        }
    }
}

