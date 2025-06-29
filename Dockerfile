# Use the Eclipse alpine official image
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:21-jdk-alpine

# Build the app.
RUN ./mvnw clean install
RUN ./mvnw clean package

# Run the app by dynamically finding the JAR file in the target directory
CMD ["sh", "-c", "java -jar target/*.jar"]