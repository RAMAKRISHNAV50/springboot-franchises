# Stage 1: Build using JDK 25 directly
FROM eclipse-temurin:25-jdk-alpine AS build
WORKDIR /app
# Install Maven manually since there's no pre-combined JDK 25 image
RUN apk add --no-cache maven
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Use the PORT environment variable provided by Render
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--server.port=${PORT}"]