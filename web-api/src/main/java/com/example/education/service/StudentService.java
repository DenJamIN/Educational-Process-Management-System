package com.example.education.service;

import com.example.education.model.Student;
import com.example.education.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student studentDetails){
        return studentRepository.findById(id).map(student -> {
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setEmail(studentDetails.getEmail());
            student.setEnrollmentDate(studentDetails.getEnrollmentDate());
            return studentRepository.save(student);
        });
    }

    public boolean deleteStudent(Long id){
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return true;
        }).orElse(false);
    }
}
