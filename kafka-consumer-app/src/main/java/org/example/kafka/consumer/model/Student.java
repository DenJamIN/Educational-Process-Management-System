package org.example.kafka.consumer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "students")
@Data
@Getter
@Setter
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
}
