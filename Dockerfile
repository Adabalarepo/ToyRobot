# Use official maven base image for build stage
FROM maven:3.8.4-openjdk-8-slim AS build

# Set working directory
WORKDIR /app

# Copy Maven build file and source code
COPY pom.xml . 
COPY src ./src

# Install Maven dependencies and build the project
RUN mvn clean package -DskipTests

# Use openjdk base image for the final stage
FROM openjdk:8-jre-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/toyrobot-1.0-SNAPSHOT.jar /app/toyrobot-1.0-SNAPSHOT.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/toyrobot-1.0-SNAPSHOT.jar"]
