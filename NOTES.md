# 🚀 Student Management API - Learning Notes

> Author: Mahendra Gampala
> Project: Student Management REST API
> Tech Stack: Java, Spring Boot, Spring Data JPA, Hibernate, MySQL

---

# Project Architecture

```
Postman
    │
    ▼
Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
Hibernate (JPA)
    │
    ▼
MySQL Database
```

Every layer has only ONE responsibility.

---

# 1. Spring Boot Startup

Application starts from

```java
public static void main(String[] args) {
    SpringApplication.run(StudentManagementApiApplication.class, args);
}
```

## What happens internally?

```
main()

↓

SpringApplication.run()

↓

Spring Container Created

↓

Component Scan

↓

Beans Created

↓

Dependencies Injected

↓

Tomcat Starts

↓

Application Ready
```

---

# 2. Spring Container

The Spring Container is responsible for

- Creating Objects (Beans)
- Managing Objects
- Injecting Dependencies
- Managing Bean Lifecycle

Think of it as the manager of the entire application.

---

# 3. Bean

Definition

> A Bean is an object created and managed by the Spring Container.

Example

```java
@Service
public class StudentServiceImpl{
}
```

Spring creates this object automatically.

---

# 4. IoC (Inversion of Control)

Without Spring

```java
StudentService service = new StudentService();
```

You create the object.

With Spring

```java
@Service
public class StudentService{
}
```

Spring creates the object.

This is called

Inversion of Control (IoC).

---

# 5. Dependency Injection (DI)

Definition

> Spring provides the required object instead of the class creating it.

Example

```java
private final StudentRepository repository;

public StudentServiceImpl(StudentRepository repository){
    this.repository = repository;
}
```

Spring injects the Repository automatically.

Preferred Injection

✅ Constructor Injection

Avoid

❌ Field Injection (@Autowired on fields)

---

# 6. @SpringBootApplication

It is a combination of

```
@Configuration

@ComponentScan

@EnableAutoConfiguration
```

---

## @Configuration

Configuration class.

---

## @ComponentScan

Scans packages for Beans.

---

## @EnableAutoConfiguration

Automatically configures Spring Boot based on dependencies.

Example

If

```
spring-boot-starter-security
```

is added

↓

Security gets enabled automatically.

---

# 7. Component Scanning

Spring starts scanning from the package where

```
@SpringBootApplication
```

exists.

Therefore all packages should be inside

```
com.mahendra.studentmanagementapi
```

Example

```
studentmanagementapi

│

├── controller

├── service

├── repository

├── entity
```

---

# 8. application.properties

Stores application configuration.

Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management

spring.datasource.username=root

spring.datasource.password=*****

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
```

---

# 9. Hibernate

Hibernate is an ORM.

ORM

↓

Object Relational Mapping

Converts

```
Java Object

↓

SQL Query

↓

Database
```

Example

```java
repository.save(student);
```

Hibernate generates

```sql
INSERT INTO students ...
```

---

# 10. JPA

JPA

=

Java Persistence API

It is a specification.

Hibernate is one implementation of JPA.

---

# 11. Entity

```java
@Entity
```

Meaning

This class represents a database table.

Without @Entity

Hibernate ignores the class.

---

# 12. Table

```java
@Table(name="students")
```

Maps Java class

↓

Database Table

---

# 13. Primary Key

```java
@Id
private Long id;
```

Primary Key Rules

- Unique
- Cannot be NULL
- Identifies each row

---

# 14. GeneratedValue

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

MySQL automatically generates IDs.

```
1

2

3

4
```

No need to assign IDs manually.

---

# 15. Column

Example

```java
@Column(nullable=false,length=50)
private String firstName;
```

Used for

- nullable
- unique
- length
- custom column name

@Column is optional.

Hibernate automatically maps fields.

---

# 16. Lombok

Instead of writing

```java
getters

setters

constructors
```

Use

```java
@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor
```

Avoid using

```java
@Data
```

on JPA Entities in professional projects.

---

# 17. Layered Architecture

```
Controller

↓

Service

↓

Repository

↓

Database
```

---

## Controller

Responsibility

- Handle HTTP Requests
- Call Service
- Return Response

Should NOT contain business logic.

---

## Service

Responsibility

Business Logic

Examples

- Age Validation
- Duplicate Email Check
- Calculations
- Rules

---

## Repository

Responsibility

Only Database Operations

Examples

```
save()

findById()

findAll()

deleteById()
```

---

# 18. JpaRepository

```java
public interface StudentRepository
extends JpaRepository<Student,Long>
```

Student

↓

Entity

Long

↓

Primary Key Type

Methods already available

```
save()

findAll()

findById()

deleteById()

count()

existsById()
```

Spring generates implementation automatically.

---

# 19. Why Repository is Interface?

Because Spring Data JPA creates the implementation automatically.

We only define the contract.

---

# 20. Service Interface

```
StudentService
```

Defines

WHAT should happen.

---

# 21. Service Implementation

```
StudentServiceImpl
```

Defines

HOW it happens.

Annotated with

```java
@Service
```

NOT the interface.

Reason

Spring cannot create an object of an interface.

---

# 22. Controller

```java
@RestController
```

Handles HTTP Requests.

Creates REST APIs.

---

# 23. Request Mapping

```java
@RequestMapping("/api/students")
```

Base URL

---

# 24. Post Mapping

```java
@PostMapping
```

Handles

HTTP POST Request

Endpoint

```
POST /api/students
```

---

# 25. RequestBody

```java
@RequestBody Student student
```

Converts JSON

↓

Java Object

Uses

Jackson Library

---

# 26. JSON Example

```json
{
  "firstName":"Mahendra",
  "lastName":"Gampala",
  "email":"mahendra@gmail.com",
  "phoneNumber":"9876543210",
  "age":21
}
```

Automatically becomes

```java
Student student
```

---

# 27. Request Flow

```
Postman

↓

HTTP Request

↓

Tomcat

↓

DispatcherServlet

↓

Controller

↓

Service

↓

Repository

↓

Hibernate

↓

MySQL
```

Response follows the reverse path.

---

# 28. Why We Got 401 Unauthorized?

Reason

We accidentally added

```
spring-boot-starter-security
```

Spring Boot Auto Configuration enabled authentication.

Request Flow became

```
Postman

↓

Security Filter

↓

Authentication Required

↓

401 Unauthorized
```

Removing the dependency solved the issue.

Lesson

Dependencies can change application behavior.

---

# 29. Current Project Structure

```
student-management-api

│

├── controller

│     └── StudentController

│

├── service

│     ├── StudentService

│     └── StudentServiceImpl

│

├── repository

│     └── StudentRepository

│

├── entity

│     └── Student

│

├── resources

│     └── application.properties

│

└── StudentManagementApiApplication
```

---

# 30. Current Student Entity

Fields

```
id

firstName

lastName

email

phoneNumber

age
```

---

# Interview Questions

## What is a Bean?

Object managed by Spring Container.

---

## Difference between IoC and DI?

IoC

↓

Spring controls object creation.

DI

↓

Spring injects required dependencies.

---

## Why Constructor Injection?

- Immutable
- Testable
- Recommended by Spring
- Explicit Dependencies

---

## Why Interface + Implementation?

Interface

↓

Contract

Implementation

↓

Business Logic

Allows multiple implementations.

---

## Why Repository is Interface?

Spring generates implementation automatically.

---

## Why @Service only on Implementation?

Interfaces cannot be instantiated.

Spring creates objects only from concrete classes.

---

## What is Hibernate?

ORM Framework

Converts Java Objects into SQL.

---

## What is JPA?

Java Persistence Specification.

Hibernate is one implementation.

---

## Why @GeneratedValue?

Database generates IDs automatically.

---

## Why @RequestBody?

Converts JSON into Java Objects.

---

# Completed Features ✅

- Spring Boot Project Setup
- MySQL Connection
- Entity Creation
- Repository Layer
- Service Layer
- Dependency Injection
- Controller Layer
- POST REST API
- Save Student into MySQL
- Tested using Postman

---

# Next Topics

- Bean Validation
- Exception Handling
- DTO
- GET APIs
- PUT APIs
- DELETE APIs
- Pagination
- Sorting
- Searching
- Custom Queries
- Global Exception Handler
- JWT Authentication
- Spring Security