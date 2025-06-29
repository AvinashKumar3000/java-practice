FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the full project
COPY . .

# Build the app using system Maven
RUN mvn clean package -DskipTests

# Run the app
CMD ["sh", "-c", "java -jar target/*.jar"]
