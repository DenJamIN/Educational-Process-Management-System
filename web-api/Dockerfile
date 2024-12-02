FROM openjdk:17-jdk-slim

WORKDIR /app

RUN mkdir -p /app/data_exports

COPY ./target/education-service-web-api-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://education_postgres:5432/education_db
ENV SPRING_DATASOURCE_USERNAME=edu_user
ENV SPRING_DATASOURCE_PASSWORD=securepassword

ENTRYPOINT ["java", "-jar", "app.jar"]
