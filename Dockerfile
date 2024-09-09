# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Add a volume for logs
VOLUME /tmp

# Copy project jar
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

# Expose port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
