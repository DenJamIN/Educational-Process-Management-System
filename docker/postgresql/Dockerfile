FROM postgres:15

ENV POSTGRES_DB=education_db
ENV POSTGRES_USER=edu_user
ENV POSTGRES_PASSWORD=securepassword

COPY ../../databases/postgresql/scripts/ /docker-entrypoint-initdb.d/
