FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/kafka-consumer-app-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh .

ENTRYPOINT ["./wait-for-it.sh", "mongo:27017", "--", "java", "-jar", "app.jar"]
