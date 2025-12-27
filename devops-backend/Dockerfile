# ======================
# Build stage (Java 21)
# ======================
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# ======================
# Runtime stage (Java 21)
# ======================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port on which the application will run
EXPOSE 8081

# Set the command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]