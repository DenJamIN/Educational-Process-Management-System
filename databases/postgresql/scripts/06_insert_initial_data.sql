INSERT INTO teachers (first_name, last_name, email, hire_date) VALUES
('Анна', 'Петрова', 'anna.petrova@example.ru', '2015-08-15'),
('Борис', 'Сидоров', 'boris.sidorov@example.ru', '2018-03-22'),
('Виктория', 'Кузнецова', 'victoria.kuznetsova@example.ru', '2020-11-05');

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('Лаврентьев', 'Денис', 'denjamin.loverentev@example.ru', '2022-09-01'),
('Мария', 'Смирнова', 'maria.smirnova@example.ru', '2023-01-15'),
('Петр', 'Козлов', 'petr.kozlov@example.ru', '2022-09-01'),
('Елена', 'Новикова', 'elena.novikova@example.ru', '2023-03-10'),
('Сергей', 'Лебедев', 'sergey.lebedev@example.ru', '2022-09-01');

INSERT INTO courses (course_name, course_description, credits, teacher_id) VALUES
('Основы программирования', 'Введение в программирование на Java', 5, 1),
('Базы данных', 'Изучение реляционных и NoSQL баз данных', 4, 2),
('Алгоритмы и структуры данных', 'Изучение алгоритмов и их эффективных реализаций', 6, 1),
('Веб-разработка', 'Создание веб-приложений с использованием современных технологий', 5, 3),
('Машинное обучение', 'Основы машинного обучения и его применение', 6, 2);

INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2022-09-02'),
(1, 2, '2022-09-03'),
(2, 1, '2023-01-16'),
(2, 3, '2023-01-17'),
(3, 1, '2022-09-02'),
(3, 4, '2022-09-04'),
(4, 2, '2023-03-11'),
(4, 5, '2023-03-12'),
(5, 3, '2022-09-03'),
(5, 4, '2022-09-04'),
(5, 5, '2022-09-05');

INSERT INTO grades (enrollment_id, grade_value, grade_date, grade_type) VALUES
(1, 85.50, '2022-12-15', 'экзамен'),
(1, 90.00, '2023-01-15', 'зачет'),
(2, 78.00, '2022-12-16', 'экзамен'),
(3, 88.75, '2023-04-10', 'экзамен'),
(4, 92.00, '2023-05-20', 'зачет'),
(5, 80.00, '2023-01-20', 'экзамен'),
(6, 75.25, '2022-12-20', 'экзамен'),
(7, 89.00, '2023-06-15', 'зачет'),
(8, 95.00, '2023-07-10', 'экзамен'),
(9, 82.50, '2023-02-18', 'экзамен'),
(10, 88.00, '2023-03-25', 'зачет'),
(11, 91.50, '2023-04-30', 'экзамен');