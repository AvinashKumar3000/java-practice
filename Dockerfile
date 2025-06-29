# Stage 1: Build using Maven
FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run only JAR with minimal JDK
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
