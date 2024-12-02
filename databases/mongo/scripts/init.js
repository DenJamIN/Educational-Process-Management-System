db = db.getSiblingDB('education_db');

db.createCollection('students');
db.students.createIndex({ email: 1 }, { unique: true });
db.students.createIndex({ studentId: 1 }, { unique: true });