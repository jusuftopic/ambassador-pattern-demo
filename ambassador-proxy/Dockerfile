# Use official OpenJDK 21 image to build the application
FROM openjdk:21-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper script and settings
COPY mvnw ./
COPY .mvn .mvn/

# Copy the pom.xml and the source code to the container
COPY pom.xml /app/
COPY src /app/src/

# Make the Maven wrapper script executable
RUN chmod +x mvnw

# Build the app using Maven
RUN ./mvnw clean install

# Use OpenJDK 21 again to run the application
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the app's port
EXPOSE 8081

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]