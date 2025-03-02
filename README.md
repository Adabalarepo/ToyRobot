
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

## Running the Application

### Clone the Repository
```bash
git clone <repository-url>
cd toy-robot-simulator
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

| Command  | Method | URL               | Request Body |
|----------|--------|-------------------|--------------|
| PLACE    | POST   | `/api/robot/place` | `{ "x": 0, "y": 0, "direction": "NORTH" }` |
| MOVE     | POST   | `/api/robot/move`  | _None_ |
| LEFT     | POST   | `/api/robot/left`  | _None_ |
| RIGHT    | POST   | `/api/robot/right` | _None_ |
| REPORT   | GET    | `/api/robot/report` | _None_ |

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
docker build -t toy-robot-simulator .
```

### Run Docker Container
```bash
docker run -p 8080:8080 toy-robot-simulator
```
