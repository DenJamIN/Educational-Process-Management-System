db.teachers.insertMany([
    {
        teacher_id: 1,
        first_name: "Анна",
        last_name: "Петрова",
        email: "anna.petrova@example.ru",
        hire_date: new Date("2015-08-15")
    },
    {
        teacher_id: 2,
        first_name: "Борис",
        last_name: "Сидоров",
        email: "boris.sidorov@example.ru",
        hire_date: new Date("2018-03-22")
    },
    {
        teacher_id: 3,
        first_name: "Виктория",
        last_name: "Кузнецова",
        email: "victoria.kuznetsova@example.ru",
        hire_date: new Date("2020-11-05")
    }
]);

db.students.insertMany([
    {
        student_id: 1,
        first_name: "Лаврентьев",
        last_name: "Денис",
        email: "denjamin.loverentev@example.ru",
        enrollment_date: new Date("2022-09-01")
    },
    {
        student_id: 2,
        first_name: "Мария",
        last_name: "Смирнова",
        email: "maria.smirnova@example.ru",
        enrollment_date: new Date("2023-01-15")
    },
    {
        student_id: 3,
        first_name: "Петр",
        last_name: "Козлов",
        email: "petr.kozlov@example.ru",
        enrollment_date: new Date("2022-09-01")
    },
    {
        student_id: 4,
        first_name: "Елена",
        last_name: "Новикова",
        email: "elena.novikova@example.ru",
        enrollment_date: new Date("2023-03-10")
    },
    {
        student_id: 5,
        first_name: "Сергей",
        last_name: "Лебедев",
        email: "sergey.lebedev@example.ru",
        enrollment_date: new Date("2022-09-01")
    }
]);

db.courses.insertMany([
    {
        course_id: 1,
        course_name: "Основы программирования",
        course_description: "Введение в программирование на Java",
        credits: 5,
        teacher_id: 1
    },
    {
        course_id: 2,
        course_name: "Базы данных",
        course_description: "Изучение реляционных и NoSQL баз данных",
        credits: 4,
        teacher_id: 2
    },
    {
        course_id: 3,
        course_name: "Алгоритмы и структуры данных",
        course_description: "Изучение алгоритмов и их эффективных реализаций",
        credits: 6,
        teacher_id: 1
    },
    {
        course_id: 4,
        course_name: "Веб-разработка",
        course_description: "Создание веб-приложений с использованием современных технологий",
        credits: 5,
        teacher_id: 3
    },
    {
        course_id: 5,
        course_name: "Машинное обучение",
        course_description: "Основы машинного обучения и его применение",
        credits: 6,
        teacher_id: 2
    }
]);

db.enrollments.insertMany([
    {
        enrollment_id: 1,
        student_id: 1,
        course_id: 1,
        enrollment_date: new Date("2022-09-02")
    },
    {
        enrollment_id: 2,
        student_id: 1,
        course_id: 2,
        enrollment_date: new Date("2022-09-03")
    },
    {
        enrollment_id: 3,
        student_id: 2,
        course_id: 1,
        enrollment_date: new Date("2023-01-16")
    },
    {
        enrollment_id: 4,
        student_id: 2,
        course_id: 3,
        enrollment_date: new Date("2023-01-17")
    },
    {
        enrollment_id: 5,
        student_id: 3,
        course_id: 1,
        enrollment_date: new Date("2022-09-02")
    },
    {
        enrollment_id: 6,
        student_id: 3,
        course_id: 4,
        enrollment_date: new Date("2022-09-04")
    },
    {
        enrollment_id: 7,
        student_id: 4,
        course_id: 2,
        enrollment_date: new Date("2023-03-11")
    },
    {
        enrollment_id: 8,
        student_id: 4,
        course_id: 5,
        enrollment_date: new Date("2023-03-12")
    },
    {
        enrollment_id: 9,
        student_id: 5,
        course_id: 3,
        enrollment_date: new Date("2022-09-03")
    },
    {
        enrollment_id: 10,
        student_id: 5,
        course_id: 4,
        enrollment_date: new Date("2022-09-04")
    },
    {
        enrollment_id: 11,
        student_id: 5,
        course_id: 5,
        enrollment_date: new Date("2022-09-05")
    }
]);

db.grades.insertMany([
    {
        grade_id: 1,
        enrollment_id: 1,
        grade_value: 85.50,
        grade_date: new Date("2022-12-15"),
        grade_type: "экзамен"
    },
    {
        grade_id: 2,
        enrollment_id: 1,
        grade_value: 90.00,
        grade_date: new Date("2023-01-15"),
        grade_type: "зачет"
    },
    {
        grade_id: 3,
        enrollment_id: 2,
        grade_value: 78.00,
        grade_date: new Date("2022-12-16"),
        grade_type: "экзамен"
    },
    {
        grade_id: 4,
        enrollment_id: 3,
        grade_value: 88.75,
        grade_date: new Date("2023-04-10"),
        grade_type: "экзамен"
    },
    {
        grade_id: 5,
        enrollment_id: 4,
        grade_value: 92.00,
        grade_date: new Date("2023-05-20"),
        grade_type: "зачет"
    },
    {
        grade_id: 6,
        enrollment_id: 5,
        grade_value: 80.00,
        grade_date: new Date("2023-01-20"),
        grade_type: "экзамен"
    },
    {
        grade_id: 7,
        enrollment_id: 6,
        grade_value: 75.25,
        grade_date: new Date("2022-12-20"),
        grade_type: "экзамен"
    },
    {
        grade_id: 8,
        enrollment_id: 7,
        grade_value: 89.00,
        grade_date: new Date("2023-06-15"),
        grade_type: "зачет"
    },
    {
        grade_id: 9,
        enrollment_id: 8,
        grade_value: 95.00,
        grade_date: new Date("2023-07-10"),
        grade_type: "экзамен"
    },
    {
        grade_id: 10,
        enrollment_id: 9,
        grade_value: 82.50,
        grade_date: new Date("2023-02-18"),
        grade_type: "экзамен"
    },
    {
        grade_id: 11,
        enrollment_id: 10,
        grade_value: 88.00,
        grade_date: new Date("2023-03-25"),
        grade_type: "зачет"
    },
    {
        grade_id: 12,
        enrollment_id: 11,
        grade_value: 91.50,
        grade_date: new Date("2023-04-30"),
        grade_type: "экзамен"
    }
]);