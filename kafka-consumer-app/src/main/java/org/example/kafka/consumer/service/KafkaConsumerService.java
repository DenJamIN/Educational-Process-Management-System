package org.example.kafka.consumer.service;

import org.example.kafka.consumer.model.Student;
import org.example.kafka.consumer.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "student_exports", groupId = "student_export_group")
    public void consume(String message) {
        try {
            Student student = objectMapper.readValue(message, Student.class);
            studentRepository.save(student);
            System.out.println("Сохранён студент: " + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}