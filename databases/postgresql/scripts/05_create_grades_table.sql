CREATE TABLE grades (
    grade_id SERIAL PRIMARY KEY,
    enrollment_id INTEGER NOT NULL,
    grade_value DECIMAL(5,2) CHECK (grade_value >= 0 AND grade_value <= 100),
    grade_date DATE NOT NULL,
    grade_type VARCHAR(50),
    FOREIGN KEY (enrollment_id) REFERENCES enrollments(enrollment_id)
);
