# CloudTasks Project

## Project Idea: Task Management System with Cloud Notifications

### Project Overview
You’ll build a simple task management system that allows users to create, update, and delete tasks. Additionally, you will implement a scheduled notification system using AWS Lambda and CloudWatch, alongside an Azure SQL database for storing tasks.

### Technologies and Tools to Use
- **AWS Lambda**: For handling task operations and sending notifications.
- **Amazon CloudWatch**: To schedule the Lambda function to run at regular intervals.
- **Azure SQL Database**: To store tasks and maintain a change log.
- **C#**: To write your Azure SQL database logic and implement background services.
- **Java**: For the backend API, handling task requests.
- **Postman**: To test your API endpoints.
- **SonarQube**: To analyze and ensure your code quality.
- **SQL Commands**: To interact with your Azure SQL database.

### Step 1: Set Up Your Development Environment
- Set up Azure SQL Database.
- Create a table for tasks. The schema might include:
  - `TaskId` (Primary Key)
  - `Title`
  - `Description`
  - `Status` (e.g., Pending, Completed)
  - `CreatedAt`
  - `UpdatedAt`
- Create a change log table to record changes made to tasks.

**Additional Tasks:**

- **Explore Azure Data Studio**:
  - Install Azure Data Studio for managing your database.
  - Familiarize yourself with the features and tools offered by these applications for better SQL script execution and database management.

- **Enhance the Tasks Table**:
  - **Add New Columns**:
    - Consider adding columns like `DueDate`, `Priority`, and `AssignedTo` for more robust task management.
  - **Data Validation**:
    - Implement constraints to ensure data integrity, such as check constraints for valid statuses and priorities.

- **Create User Table** (Optional):
  - Set up a `Users` table to manage users if planning for multi-user functionality.
  - Ensure proper relationships are established between tasks and users.

- **Implement Relationships**:
  - If a `Users` table is created, modify the `Tasks` table to include a foreign key referencing the `Users` table.

- **Create Stored Procedures**:
  - Write stored procedures for common operations (e.g., adding, updating tasks) to encapsulate logic and improve performance.

- **Set Up Triggers for Change Log**:
  - Create triggers to automatically log changes in the `ChangeLog` table whenever tasks are created, updated, or deleted.

- **Testing Data Integrity**:
  - Insert sample data and test the behavior of your triggers and stored procedures to ensure they function as expected.

- **Backup and Restore**:
  - Research backup strategies for your database. Ensure you understand Azure’s automated backup options, and explore manual backup options for additional safety.


### Implementation Steps


#### Step 2: Create the API (Using Java)
- Set up a simple Java Spring Boot application.
- Implement the following endpoints:
  - `POST /tasks` - Create a new task
  - `GET /tasks` - Retrieve all tasks
  - `PUT /tasks/{id}` - Update an existing task
  - `DELETE /tasks/{id}` - Delete a task

**Additional Tasks:**
- Add input validation for task creation and updates (e.g., ensure fields are not empty).
- Implement pagination for the `GET /tasks` endpoint to handle a large number of tasks efficiently.

##### a. Exception Handling
- Create a custom exception class (e.g., `TaskNotFoundException`).
- Implement a global exception handler using `@ControllerAdvice`.
- Modify the Task Service to handle exceptions appropriately.

**Additional Tasks:**
- Create a structured error response format for client applications to handle errors better.

##### b. Unit Testing
- Add dependencies for testing using JUnit and Mockito.
- Create a test class for the TaskService to verify functionality.

**Additional Tasks:**
- Write integration tests that check the interaction between the API and the database.

#### Step 3: Implement Notification Logic (Using AWS Lambda)
- Create a Lambda function that checks for tasks that are overdue.
- Use the AWS SDK to send notifications (could be an email, for example) to users regarding overdue tasks.

**Additional Tasks:**
- Implement logging within your Lambda function to track execution and errors.
- Explore different notification channels, such as SMS (using Amazon SNS) or push notifications.

#### Step 4: Schedule the Lambda Function (Using CloudWatch)
- Use Amazon CloudWatch to create a rule that triggers your Lambda function every hour or at a specific interval.

**Additional Tasks:**
- Implement a retry mechanism for the Lambda function in case of failures.
- Monitor the execution logs in CloudWatch for troubleshooting.

#### Step 5: Testing (Using Postman)
- Use Postman to test your API endpoints. Verify that all CRUD operations work correctly and that tasks are stored in the database as expected.

**Additional Tasks:**
- Create Postman collections to group related API tests and automate testing with Newman.
- Explore setting up automated tests using Postman’s Collection Runner.

#### Step 6: Code Quality (Using SonarQube)
- Set up SonarQube in your project to analyze the Java code quality.
- Ensure you address any code smells or vulnerabilities it identifies.

**Additional Tasks:**
- Customize SonarQube rules to suit your coding standards.
- Create a CI/CD pipeline to integrate SonarQube checks automatically on every commit.

#### Step 7: Create a Change Log
- Each time a task is created, updated, or deleted, insert a record into the change log table capturing:
  - `ChangeId`
  - `TaskId`
  - `ChangeType` (Created, Updated, Deleted)
  - `ChangeDate`

**Additional Tasks:**
- Add a feature to view the change log through an API endpoint.
- Implement filtering options for the change log (e.g., by date or task ID).

#### Step 8: C# Integration for Task Management
- **Create a C# Console Application**:
  - Use this application to interact with the Azure SQL Database. The console application can perform operations such as adding tasks and retrieving them.
  
  Example code snippet to add a task:
  ```csharp
  using System;
  using System.Data.SqlClient;

  class Program
  {
      static void Main(string[] args)
      {
          string connectionString = "Your_Connection_String";

          using (SqlConnection connection = new SqlConnection(connectionString))
          {
              connection.Open();
              string insertQuery = "INSERT INTO Tasks (Title, Description, Status) VALUES (@Title, @Description, @Status)";
              SqlCommand command = new SqlCommand(insertQuery, connection);
              command.Parameters.AddWithValue("@Title", "New Task");
              command.Parameters.AddWithValue("@Description", "This is a new task.");
              command.Parameters.AddWithValue("@Status", "Pending");
              command.ExecuteNonQuery();
          }
      }
  }
  ```

**Additional Tasks:**
- Implement command-line arguments to allow dynamic task creation from the console.
- Create a background service in C# that periodically checks for overdue tasks and updates their status or sends notifications.

### Security Considerations
- Never log sensitive information such as passwords. Ensure that error messages do not expose sensitive details.
- Implement proper authorization (JWT or OAuth2) if you plan to expand this project for user authentication.

### Learning Outcomes
By building this project, you’ll learn how to:
- Work with AWS Lambda and CloudWatch for serverless computing.
- Create and interact with a database using SQL commands.
- Develop a RESTful API in Java.
- Utilize Postman for testing APIs.
- Implement code quality checks using SonarQube.
- Understand the principles of task scheduling and notifications in a cloud environment.
- Handle exceptions effectively in your code.
- Write unit tests for better code reliability.
- Differentiate between classes and objects, and understand their roles in object-oriented programming.
- Enhance your skills in C# for database interactions and background processing.

