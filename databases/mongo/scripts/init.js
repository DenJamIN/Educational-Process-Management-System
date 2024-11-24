db = db.getSiblingDB('education_db');

db.createCollection('teachers');
db.teachers.createIndex({ email: 1 }, { unique: true });

db.createCollection('students');
db.students.createIndex({ email: 1 }, { unique: true });

db.createCollection('courses');
db.courses.createIndex({ course_id: 1 }, { unique: true });
db.courses.createIndex({ teacher_id: 1 });

db.createCollection('enrollments');
db.enrollments.createIndex({ enrollment_id: 1 }, { unique: true });
db.enrollments.createIndex({ student_id: 1 });
db.enrollments.createIndex({ course_id: 1 });
db.enrollments.createIndex({ student_id: 1, course_id: 1 }, { unique: true });

db.createCollection('grades');
db.grades.createIndex({ grade_id: 1 }, { unique: true });
db.grades.createIndex({ enrollment_id: 1 });