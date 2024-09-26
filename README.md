# CloudTasks Project

## Project Idea: Task Management System with Cloud Notifications

### Project Overview
You’ll build a simple task management system that allows users to create, update, and delete tasks. Additionally, you will implement a scheduled notification system using AWS Lambda and CloudWatch, alongside an Azure SQL database for storing tasks.

### Technologies and Tools to Use
- **AWS Lambda**: For handling task operations and sending notifications.
- **Amazon CloudWatch**: To schedule the Lambda function to run at regular intervals.
- **Azure SQL Database**: To store tasks and maintain a change log.
- **C#**: To write your Azure SQL database logic.
- **Java**: For the backend API, handling task requests.
- **Postman**: To test your API endpoints.
- **SonarQube**: To analyze and ensure your code quality.
- **SQL Commands**: To interact with your Azure SQL database.

### Implementation Steps

#### Step 1: Set Up Your Development Environment
- Set up Azure SQL Database.
- Create a table for tasks. The schema might include:
  - `TaskId` (Primary Key)
  - `Title`
  - `Description`
  - `Status` (e.g., Pending, Completed)
  - `CreatedAt`
  - `UpdatedAt`
- Create a change log table to record changes made to tasks.

#### Step 2: Create the API (Using Java)
- Set up a simple Java Spring Boot application.
- Implement the following endpoints:
  - `POST /tasks` - Create a new task
  - `GET /tasks` - Retrieve all tasks
  - `PUT /tasks/{id}` - Update an existing task
  - `DELETE /tasks/{id}` - Delete a task

##### a. Exception Handling
- Create a custom exception class (e.g., `TaskNotFoundException`).
- Implement a global exception handler using `@ControllerAdvice`.
- Modify the Task Service to handle exceptions appropriately.

##### b. Unit Testing
- Add dependencies for testing using JUnit and Mockito.
- Create a test class for the TaskService to verify functionality.

#### Step 3: Implement Notification Logic (Using AWS Lambda)
- Create a Lambda function that checks for tasks that are overdue.
- Use the AWS SDK to send notifications (could be an email, for example) to users regarding overdue tasks.

#### Step 4: Schedule the Lambda Function (Using CloudWatch)
- Use Amazon CloudWatch to create a rule that triggers your Lambda function every hour or at a specific interval.

#### Step 5: Testing (Using Postman)
- Use Postman to test your API endpoints. Verify that all CRUD operations work correctly and that tasks are stored in the database as expected.

#### Step 6: Code Quality (Using SonarQube)
- Set up SonarQube in your project to analyze the Java code quality.
- Ensure you address any code smells or vulnerabilities it identifies.

#### Step 7: Create a Change Log
- Each time a task is created, updated, or deleted, insert a record into the change log table capturing:
  - `ChangeId`
  - `TaskId`
  - `ChangeType` (Created, Updated, Deleted)
  - `ChangeDate`

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

