package com.example.education.service;

import com.example.education.model.Teacher;
import com.example.education.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id){
        return teacherRepository.findById(id);
    }

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> updateTeacher(Long id, Teacher teacherDetails){
        return teacherRepository.findById(id).map(teacher -> {
            teacher.setFirstName(teacherDetails.getFirstName());
            teacher.setLastName(teacherDetails.getLastName());
            teacher.setEmail(teacherDetails.getEmail());
            teacher.setHireDate(teacherDetails.getHireDate());
            return teacherRepository.save(teacher);
        });
    }

    public boolean deleteTeacher(Long id){
        return teacherRepository.findById(id).map(teacher -> {
            teacherRepository.delete(teacher);
            return true;
        }).orElse(false);
    }
}
