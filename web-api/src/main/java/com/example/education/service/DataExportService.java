package com.example.education.service;

import com.example.education.model.Student;
import com.example.education.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DataExportService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private final static String EXPORT_DIRECTORY = "/app/data_exports";

    @Scheduled(timeUnit = TimeUnit.MILLISECONDS, fixedRate = 60_000)
    public void exportData() {
        List<Student> students = studentRepository.findAll();
        String filename = "students_export_" + System.currentTimeMillis() + ".json";
        File file = new File(EXPORT_DIRECTORY + "/" + filename);
        try {
            objectMapper.writeValue(file, students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
