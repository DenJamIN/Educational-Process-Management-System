FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/kafka-consumer-app-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
