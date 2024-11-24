FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN mkdir -p /app

COPY ../../spark-structured-streaming/target/spark-structured-streaming-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
