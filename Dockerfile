# Use lightweight JDK image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper scripts
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Pre-download dependencies to speed up builds
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["sh", "-c", "java -jar target/*.jar"]
