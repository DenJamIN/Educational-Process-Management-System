package com.example.education.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, length = 100)
    private String courseName;

    @Column(columnDefinition = "TEXT")
    private String courseDescription;

    @Column(nullable = false)
    private Integer credits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
