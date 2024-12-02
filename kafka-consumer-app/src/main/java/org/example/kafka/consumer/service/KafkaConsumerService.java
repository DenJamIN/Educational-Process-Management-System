package org.example.kafka.consumer.service;

import org.example.kafka.consumer.model.Student;
import org.example.kafka.consumer.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final StudentRepository studentRepository;

    @Autowired
    public KafkaConsumerService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @KafkaListener(topics = "student_exports", groupId = "student_export_group")
    public void consume(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Student student = objectMapper.readValue(message, Student.class);
            studentRepository.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
