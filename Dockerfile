# Use official openjdk base image
FROM openjdk:8-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven build file and source code
COPY pom.xml .
COPY src ./src

# Install Maven and build the project
RUN apt-get update && apt-get install -y maven
RUN mvn clean install

# Expose the port your app will run on
EXPOSE 8080

# Command to run
