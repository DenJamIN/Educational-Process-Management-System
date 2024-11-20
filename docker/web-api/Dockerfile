FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ../../web-api/target/education-service-web-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
