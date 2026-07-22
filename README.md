# Poise Pms Back end

A full-stack Project Management System built with **Spring Boot**, **React**, and **MySQL**. This application allows engineering and construction companies to manage projects, customers, architects, contractors, structural engineers, and project managers.

This project is a modern rebuild of my original Java console application, transforming it into a RESTful web application using Spring Boot and React.

---

## Features

- Manage projects
- Manage architects
- Manage customers
- Manage contractors
- Manage structural engineers
- Manage project managers
- Assign projects to each professional
- View all projects assigned to a specific:
  - Architect
  - Customer
  - Contractor
  - Structural Engineer
  - Project Manager
- Create, Read, Update and Delete (CRUD) operations
- RESTful API
- MySQL database integration
- DTO pattern for data transfer
- Entity relationships using JPA/Hibernate

---

## Technologies Used

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

### Frontend

- React
- JavaScript
- HTML
- CSS
- Bootstrap

### Development Tools

- IntelliJ IDEA
- VS Code
- Git
- GitHub
- Postman

---

## Database Design

The application uses a relational MySQL database.

Main entities include:

- Project
- Architect
- Customer
- Contractor
- Structural Engineer
- Project Manager

Relationships are managed using JPA annotations such as:

- `@ManyToOne`
- `@OneToMany`

---

## Project Structure

```
src
├── data
│   ├── entity
│   └── repository
│
├── web
│   ├── controller
│   ├── DTO
│   └── service
│
└── BackEndApplication
```

The application follows a layered architecture:

```
React
    ↓
REST Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL Database
```

---

## REST API

Example endpoints:

### Architects

```
GET    /architect
GET    /architect/{id}
POST   /architect
PUT    /architect/{id}
DELETE /architect/{id}
```

### Projects

```
GET    /project
GET    /project/{id}
POST   /project
PUT    /project/{id}
DELETE /project/{id}
```

Additional endpoints include retrieving projects by:

- Architect
- Customer
- Contractor
- Structural Engineer
- Project Manager

---

## Running the Project

### Clone the repository

```bash
git clone https://github.com/Lethabo366/Poised-Pms-V2_Back-End.git
```

### Configure the database

Create a MySQL database and update:

```
application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/poisedpms
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### Run

```bash
mvn spring-boot: run
```

or run the project directly from IntelliJ IDEA.

---

## Future Improvements

- Authentication and Authorization (Spring Security + JWT)
- Validation using Bean Validation
- Global Exception Handling
- Pagination
- Search and Filtering
- Docker support
- Cloud deployment
- CI/CD using GitHub Actions
- Unit and Integration Testing
- API Documentation using Swagger/OpenAPI

---

## What I Learned

This project strengthened my understanding of:

- Spring Boot
- REST API development
- Object-Oriented Programming
- Dependency Injection
- Services and Repositories
- JPA/Hibernate
- Entity Relationships
- DTO Mapping
- Error Handling
- CRUD operations
- React communicating with a Spring Boot backend
- Git and GitHub workflows

---

## Author

**Lethabo Kaphioa**

GitHub:
https://github.com/Lethabo366

LinkedIn:
L

---

## License

This project is intended for educational and portfolio purposes.
