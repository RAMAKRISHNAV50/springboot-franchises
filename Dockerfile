# Stage 1: Build the application using Maven and JDK 25
FROM maven:3.9.9-eclipse-temurin-25-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render or Railway will provide the PORT variable
EXPOSE 8080

# Use the PORT environment variable to set the server port dynamically
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--server.port=${PORT}"]