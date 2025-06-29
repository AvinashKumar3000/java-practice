FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the full project
COPY . .

# Build the app using system Maven
RUN sudo apt install mvn 
RUN mvn clean install
RUN mvn clean package 

# Run the app
CMD ["sh", "-c", "java -jar target/*.jar"]
