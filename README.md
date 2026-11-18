# Quiz Management Platform – Spring Boot REST API

A backend for online quizzes. **Teachers** create questions and quizzes, **students** take them, and the system **scores and grades** the answers automatically and keeps a result history.

## Features
- **Users:** register, update profile and log in. Passwords are hashed with Spring Security's `PasswordEncoder`. Each user has a role (teacher or student).
- **Questions:** create questions and fetch a **random set of questions for a topic**
- **Quizzes:** generate a quiz for a topic from a random set of questions, and list quizzes by topic
- **Results:** submit answers and get an automatic score, percentage and grade (**A, B, C, D or FAIL**)
- **Analytics:** results per user, results per quiz, **top 5 students per quiz** and a list of students who failed

## Architecture
```
controller  →  service (interface + implementation)  →  dao (Spring Data JPA)  →  MySQL
     ↑                       ↑
  DTOs (request/response, ModelMapper)    entities (User, Quiz, Question, Result)
```
- **Layered design:** Controller, Service and DAO layers, with separate request and response DTOs
- **Validation:** Bean Validation plus a **custom annotation** (`@ValidOptions`) that checks question options
- **Error handling:** a global `@RestControllerAdvice` exception handler and custom exceptions (`ResourceNotFoundException`, `QuizApplicationException`)
- **Consistent API responses:** an `ApiResponse` wrapper built with the builder pattern
- **Git workflow:** each layer was built on its own feature branch (model, DTOs, DAO, exception handling, controller, services) and merged through pull requests

## REST Endpoints (overview)

| Resource | Method & Path | Purpose |
|---|---|---|
| User | `POST /user` | Register a user |
| User | `PUT /user/{id}` | Update a user |
| User | `POST /user/login` | Log in |
| Question | `POST /question` | Create a question |
| Question | `GET /question/{id}` | Get one question |
| Question | `GET /question/fetch_set_of_questions?topic=…&noOfQuestions=…` | Get a random question set for a topic |
| Quiz | `POST /quiz?topic=…&noOfQuestion=…` | Generate a quiz for a topic |
| Quiz | `GET /quiz/{id}` | Get one quiz |
| Quiz | `GET /quiz/list_of_quiz?topic=…` | List quizzes for a topic |
| Result | `POST /result` | Submit answers → score and grade |
| Result | `GET /result/list_of_result/user/{uId}` | Results of one user |
| Result | `GET /result/list_of_result/quiz/{qId}` | Results of one quiz |
| Result | `GET /result/list_of_result/user/top5/{qId}` | Top 5 students of a quiz |
| Result | `GET /result/list_of_result/user/fail/{qId}` | Students who failed a quiz |

## Tech Stack
Java 17 · Spring Boot 3 · Spring Web · Spring Data JPA (Hibernate) · Spring Security · Bean Validation · ModelMapper · Lombok · MySQL · Maven

## Run locally
1. Create a MySQL database and add the connection settings to `backend/src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
   spring.datasource.username=<your-user>
   spring.datasource.password=<your-password>
   spring.jpa.hibernate.ddl-auto=update
   ```
2. Start the app:
   ```bash
   cd backend
   ./mvnw spring-boot:run
   ```
3. The API runs on `http://localhost:8080`.
