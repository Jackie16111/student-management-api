# 🚀 Student Management System API

A **Spring Boot REST API** for managing students with full CRUD operations, validation, and clean architecture.

---

## 📌 Features

* ✅ Add Student
* ✅ Get All Students
* ✅ Update Student
* ✅ Delete Student
* ✅ Input Validation (`@Valid`)
* ✅ Global Exception Handling
* ✅ DTO Pattern (no direct Entity exposure)
* ✅ Logging implemented
* ✅ MySQL Database Integration

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven

---

## 🧱 Project Structure

```
controller → handles HTTP requests  
service → business logic  
repository → database access  
model → entity (DB structure)  
DTO → data transfer object  
exception → global error handling  
```

---

## 🔗 API Endpoints

### ➤ Get All Students

```
GET /students
```

---

### ➤ Add Student

```
POST /students
```

**Request Body**

```json
{
  "name": "Jackie",
  "course": "Java",
  "age": 22
}
```

---

### ➤ Update Student

```
PUT /students/{id}
```

---

### ➤ Delete Student

```
DELETE /students/{id}
```

---

## ⚙️ Database Configuration

Update your `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

---

## ▶️ Run the Project

```
mvn spring-boot:run
```

Server runs on:

```
http://localhost:8081
```

---

## 🧠 Key Concepts Implemented

* REST API Design
* Layered Architecture
* DTO Pattern
* Validation (`@Valid`, `@NotNull`, etc.)
* Exception Handling (`@RestControllerAdvice`)
* JPA & Hibernate ORM
* Dependency Injection

---

## 📈 Future Improvements

* 🔐 Spring Security (Authentication & Authorization)
* 📄 Pagination & Sorting
* 🔍 Search / Filtering
* 🧪 Unit Testing (JUnit, Mockito)
* 📦 Docker Deployment

---

## 👨‍💻 Author

**Jackie Mahida**

---

## ⭐ Notes

This project is built as part of learning backend development with Java and Spring Boot, focusing on writing **clean, structured, and scalable code**.
