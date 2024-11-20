package com.example.education.service;

import com.example.education.model.Course;
import com.example.education.repository.CourseRepository;
import com.example.education.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public Optional<Course> createCourse(Course course){
        if(!teacherRepository.existsById(course.getTeacher().getTeacherId())){
            return Optional.empty();
        }
        return Optional.of(courseRepository.save(course));
    }

    public Optional<Course> updateCourse(Long id, Course courseDetails){
        return courseRepository.findById(id).map(course -> {
            course.setCourseName(courseDetails.getCourseName());
            course.setCourseDescription(courseDetails.getCourseDescription());
            course.setCredits(courseDetails.getCredits());
            course.setTeacher(courseDetails.getTeacher());
            return courseRepository.save(course);
        });
    }

    public boolean deleteCourse(Long id){
        return courseRepository.findById(id).map(course -> {
            courseRepository.delete(course);
            return true;
        }).orElse(false);
    }
}
