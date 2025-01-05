package com.example.education.service;

import com.example.education.model.Student;
import com.example.education.repository.StudentRepository;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DataExportService {

    @Autowired
    private StudentRepository studentRepository;

    private final static String EXPORT_DIRECTORY = "/app/data_exports";

    @Scheduled(timeUnit = TimeUnit.MILLISECONDS, fixedRate = 60_000)
    public void exportData() {
        List<Student> students = studentRepository.findAll();
        String filename = "students_export_" + System.currentTimeMillis() + ".csv";

        File file = new File(EXPORT_DIRECTORY + "/" + filename);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            String[] header = {"student_id", "first_name", "last_name", "email", "enrollment_date"};
            writer.writeNext(header);

            for (Student student : students) {
                String[] studentData = {
                        String.valueOf(student.getStudentId()),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.getEnrollmentDate().toString()
                };
                writer.writeNext(studentData);
            }

            System.out.println("Exported " + students.size() + " students to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
