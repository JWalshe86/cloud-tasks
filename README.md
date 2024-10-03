Certainly! Here's your **CloudTasks Project** with checkboxes, so you can track and tick off tasks as you complete them:

---

# CloudTasks Project

## Project Idea: Task Management System with Cloud Notifications

### Project Overview
You’ll build a simple task management system that allows users to create, update, and delete tasks. Additionally, you will implement a scheduled notification system using AWS Lambda and CloudWatch, alongside an Azure SQL database for storing tasks.

### Technologies and Tools to Use
- **AWS Lambda**: For handling task operations and sending notifications.
- **Amazon CloudWatch**: To schedule the Lambda function to run at regular intervals.
- **Azure SQL Database**: To store tasks and maintain a change log.
- **C#**: For Azure SQL database logic, implementing background services, and integrating LINQ and unit testing.
- **Java**: For the backend API, handling task requests.
- **Postman**: To test your API endpoints.
- **SonarQube**: To analyze and ensure your code quality.
- **SQL Commands**: To interact with your Azure SQL database.

### Step 1: Set Up Your Development Environment
- [ ] **Download Visual Studio**: Install Visual Studio for writing and debugging your C# code.
- [ ] **Set up Azure SQL Database**:
  - [ ] Create a table for tasks (`TaskId`, `Title`, `Description`, `Status`, `DueDate`, `CreatedAt`, `UpdatedAt`).
  - [ ] Create a change log table to track updates and modifications.
- [ ] **Explore Azure Data Studio**: Install and familiarize yourself with Azure Data Studio to manage your database.
  
**Additional Tasks**:
- [ ] Add columns like `Priority` and `AssignedTo` for advanced task management.
- [ ] Write stored procedures for adding, updating, and deleting tasks.
- [ ] Implement triggers to automatically log changes in the change log table.

---

### Step 2: Write Your First C# Console Application for Database Interaction
- [ ] **Create a C# Console App** in Visual Studio to interact with the Azure SQL Database. Example task insertion code is provided.
- [ ] **Add LINQ Queries** to query and manipulate the task data efficiently.

**Additional Tasks**:
- [ ] Modify the console app to accept command-line arguments for dynamic task creation.
- [ ] Implement background services in C# to periodically check for overdue tasks or send notifications.

---

### Step 3: Build the API (Using Java)
- [ ] **Set up a Spring Boot Project** in Java for the backend API.
- [ ] Implement basic CRUD operations (`POST`, `GET`, `PUT`, `DELETE`) for task management.

**Additional Tasks**:
- [ ] Add input validation for task creation and updates.
- [ ] Implement exception handling using `@ControllerAdvice`.

---

### Step 4: Write xUnit Tests in C# for Database Logic
- [ ] **Set up xUnit** in your C# project to write unit tests for task operations (e.g., adding and deleting tasks).
  
**Additional Tasks**:
- [ ] Write integration tests for the C# console app to validate interaction with the Azure SQL database.
- [ ] Implement unit tests for your **LINQ** queries.

---

### Step 5: Implement Task Notification Logic (Using AWS Lambda)
- [ ] **Write a Lambda function** that checks for overdue tasks and sends notifications via **Amazon SNS** (email/SMS).
  
**Additional Tasks**:
- [ ] Add logging within your Lambda function for tracking execution and errors.
- [ ] Implement retry mechanisms in case of notification failures.

---

### Step 6: Schedule Lambda with CloudWatch
- [ ] **Create a CloudWatch event** to trigger the Lambda function at regular intervals (e.g., hourly).

**Additional Tasks**:
- [ ] Use CloudWatch logs to monitor execution and troubleshoot errors.

---

### Step 7: API Testing with Postman
- [ ] **Use Postman** to test all API endpoints (CRUD operations) for task management.
- [ ] Verify that tasks are being stored and updated in the Azure SQL database.

**Additional Tasks**:
- [ ] Organize Postman tests into collections.
- [ ] Automate the tests using Postman’s **Collection Runner** and **Newman**.

---

### Step 8: Code Quality with SonarQube
- [ ] **Set up SonarQube** in your Java project to ensure code quality.

**Additional Tasks**:
- [ ] Customize **SonarQube rules** to match your project needs.
- [ ] Integrate SonarQube checks into a CI/CD pipeline.

---

### Learning Outcomes
By completing this project, you’ll gain experience in:
- [ ] Using **C#** for database interaction with **LINQ** and writing **xUnit** tests.
- [ ] Managing databases with **Azure SQL** and **SQL commands**.
- [ ] Building a **Java Spring Boot** API for task management.
- [ ] Implementing **AWS Lambda** and **CloudWatch** for serverless notifications.
- [ ] Testing APIs with **Postman** and automating these tests.
- [ ] Analyzing code quality with **SonarQube**.


