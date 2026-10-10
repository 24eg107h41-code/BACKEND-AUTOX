# Stage 1: Build AutoX
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy project configuration
COPY pom.xml .

# Download dependencies using the installed Maven
RUN mvn -B dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn -B clean package -DskipTests

# Stage 2: Run AutoX
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/Autox-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]