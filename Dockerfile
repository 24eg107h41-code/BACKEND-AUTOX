# Stage 1: Build AutoX
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy the complete backend project
COPY . .

# Build the Spring Boot application
RUN mvn -B clean package -DskipTests

# Stage 2: Run AutoX
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the generated JAR
COPY --from=build /app/target/Autox-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Start AutoX
ENTRYPOINT ["java", "-jar", "app.jar"]