

# POISE PMS v2 - Backend

A RESTful backend API for the POISE Project Management System built with **Java**, **Spring Boot**, and **MySQL**.

This application provides endpoints for managing construction projects and the people involved in them, including architects, customers, contractors, structural engineers, and project managers.

---

## Features

- RESTful API
- CRUD operations for all entities
- Project assignment to:
  - Architects
  - Customers
  - Contractors
  - Structural Engineers
  - Project Managers
- Retrieve projects by assigned professional
- DTO pattern
- Entity relationships using Spring Data JPA and Hibernate
- MySQL database integration
- Exception handling for missing resources

---

## Technologies

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## Architecture

The application follows a layered architecture:

```
Controller
     │
     ▼
Service
     │
     ▼
Repository
     │
     ▼
MySQL Database
```

Each layer has a single responsibility:

- **Controllers** handle HTTP requests and responses.
- **Services** contain the business logic.
- **Repositories** communicate with the database.
- **Entities** represent database tables.
- **DTOs** transfer data between the API and clients.

---

## Project Structure

```
src
└── main
    └── java
        └── com.example.backend
            ├── data
            │   ├── entity
            │   └── repository
            ├── web
            │   ├── controller
            │   ├── DTO
            │   └── service
            └── BackEndApplication
```

---

## Database

The application uses MySQL with the following primary entities:

- Project
- Architect
- Customer
- Contractor
- Structural Engineer
- Project Manager

Relationships are managed using JPA annotations including:

- `@ManyToOne`
- `@OneToMany`

---

## REST API Endpoints

### Projects

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/project` | Get all projects |
| GET | `/project/{id}` | Get a project by ID |
| POST | `/project` | Create a project |
| PUT | `/project/{id}` | Update a project |
| DELETE | `/project/{id}` | Delete a project |

### Architects

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/architect` | Get all architects |
| GET | `/architect/{id}` | Get architect by ID |
| POST | `/architect` | Create architect |
| PUT | `/architect/{id}` | Update architect |
| DELETE | `/architect/{id}` | Delete architect |
| GET | `/architect/{id}/projects` | Get projects assigned to an architect |

Similar CRUD endpoints are available for:

- Customers
- Contractors
- Structural Engineers
- Project Managers

---

## Running the Application

### Clone the repository

```bash
git clone https://github.com/Lethabo366/Poised-Pms-V2_Back-End.git
```

### Configure the database

Update your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/poisedpms
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

### Build

```bash
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

or run `BackEndApplication.java` directly from IntelliJ IDEA.

---

## Future Improvements

- Spring Security
- JWT Authentication
- Global Exception Handling (`@ControllerAdvice`)
- Request Validation (`@Valid`)
- Pagination
- Sorting
- Filtering
- Swagger/OpenAPI Documentation
- Unit Tests
- Integration Tests
- Docker Support
- CI/CD with GitHub Actions

---

## Skills Demonstrated

This project demonstrates knowledge of:

- Java
- Object-Oriented Programming
- Spring Boot
- REST API Development
- Spring Data JPA
- Hibernate
- MySQL
- Repository Pattern
- Service Layer Architecture
- DTO Mapping
- Dependency Injection
- Entity Relationships
- Exception Handling
- Git & GitHub

---

## Author

**Lethabo Kaphioa**

GitHub: https://github.com/Lethabo366

---

## License

This project is intended for educational and portfolio purposes.

