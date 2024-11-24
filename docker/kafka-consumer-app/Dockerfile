FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ../../kafka-consumer-app/target/kafka-consumer-app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
