# Toy Robot Simulator API

## Overview

This project provides a RESTful API for a Toy Robot Simulator, built using Java 8 and Spring Boot. The simulator operates on a 5x5 grid where a robot can be placed, moved, and rotated while following specific constraints.

### Rules:

- The robot cannot fall off the table.
- Any move that would place the robot outside the grid is ignored.

## Tech Stack

- **Java 8**
- **Spring Boot**
- **Maven**
- **JUnit (for unit testing)**
- **Docker (optional, for containerization)**
- **PostgreSQL (optional, for persistence)**
- **Postman (for API testing)**

## Security Implementation (Future Scope)

Currently, the API does not have authentication enabled. However, in the future, authentication can be enabled using Spring Security.

Example (for future implementation):

```properties
spring.security.user.name=robot
spring.security.user.password=robot123
```

## Database Logic (PostgreSQL)

The application supports storing robot state in PostgreSQL.

Example properties (to be added in `application.properties` or `application-cloud.properties`):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/robotdb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

**Note:** The application runs with in-memory logic if no DB is configured.

## 📂 Configuration Files Notice

This project includes two placeholder property files:

```
/toyrobot/src/main/resources/application-cloud.properties
/toyrobot/src/main/resources/application-docker.properties
```

🔔 **Why are these files empty?**

These files are intentionally left empty as placeholders to support environment-specific configurations for Cloud and Docker deployments in the future.

## Running the Application

### Clone the Repository

```bash
git clone <repository-url>
cd toyrobot
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

### Access the API

Visit: [http://localhost:8080/](http://localhost:8080/)

## API Endpoints

| Command | Method | URL                 | Request Body                               |
| ------- | ------ | ------------------- | ------------------------------------------ |
| PLACE   | POST   | `/api/robot/place`  | `{ "x": 0, "y": 0, "direction": "NORTH" }` |
| MOVE    | POST   | `/api/robot/move`   | *None*                                     |
| LEFT    | POST   | `/api/robot/left`   | *None*                                     |
| RIGHT   | POST   | `/api/robot/right`  | *None*                                     |
| REPORT  | GET    | `/api/robot/report` | *None*                                     |

## Example Usage

### Place the Robot at (0,0) Facing NORTH

```json
POST /api/robot/place
{
  "x": 0,
  "y": 0,
  "direction": "NORTH"
}
```

### Move the Robot

```bash
POST /api/robot/move
```

**Result:** Moves to (0,1), still facing NORTH.

### Get Robot's Position

```bash
GET /api/robot/report
```

**Response:**

```json
{
  "x": 0,
  "y": 1,
  "direction": "NORTH"
}
```

## Running with Docker (Optional)

### Build Docker Image

```bash
docker build -t toyrobot .
```

### Run Docker Container

```bash
docker run -p 8080:8080 toyrobot
```

## Using Postman for API Testing

### Steps to Use Postman:

1. Open **Postman** (Ensure you're using version 2.1).
2. Import the provided **Postman Collection** from the repository.
3. Use the following endpoints to interact with the API:
   - **POST** `/api/robot/place` – Place the robot on the grid.
   - **POST** `/api/robot/move` – Move the robot forward.
   - **POST** `/api/robot/left` – Rotate the robot left.
   - **POST** `/api/robot/right` – Rotate the robot right.
   - **GET** `/api/robot/report` – Get the robot's current position.
4. Send requests to test the behavior and validate responses.

**Tip:**
- Ensure that the application is running before testing with Postman.
- Check API responses to verify expected behavior.

