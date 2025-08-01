# Stage 1: Build with Maven
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies first for caching
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the jar, skipping tests to speed up build
RUN mvn clean package -DskipTests

# Stage 2: Lightweight runtime image
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/RatingService-0.0.1-SNAPSHOT.jar app.jar

# Expose the service port
EXPOSE 4030

# Run the application with docker profile active
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]
