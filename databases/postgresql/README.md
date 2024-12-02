## Databases

> **Перейти в БД Postgres**
> ```shell
> docker exec -it education_postgres psql -U edu_user -W education_db
> ```

Содержит конфигурации и скрипты для баз данных.

- **postgresql/** — настройки и скрипты для PostgreSQL.
- **mongodb/** — настройки и скрипты для MongoDB.

```mermaid
erDiagram
    STUDENTS {
        SERIAL student_id PK
        VARCHAR first_name
        VARCHAR last_name
        VARCHAR email
        DATE enrollment_date
    }
    TEACHERS {
        SERIAL teacher_id PK
        VARCHAR first_name
        VARCHAR last_name
        VARCHAR email
        DATE hire_date
    }
    COURSES {
        SERIAL course_id PK
        VARCHAR course_name
        TEXT course_description
        INTEGER credits
        INTEGER teacher_id FK
    }
    ENROLLMENTS {
        SERIAL enrollment_id PK
        INTEGER student_id FK
        INTEGER course_id FK
        DATE enrollment_date
    }
    GRADES {
        SERIAL grade_id PK
        INTEGER enrollment_id FK
        DECIMAL grade_value
        DATE grade_date
        VARCHAR grade_type
    }

    STUDENTS ||--o{ ENROLLMENTS : enrolls
    COURSES ||--o{ ENROLLMENTS : includes
    TEACHERS ||--|{ COURSES : teaches
    ENROLLMENTS ||--o{ GRADES : receives
```