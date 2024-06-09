package com.scam_exam.answers_storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    @Column(nullable = false)
    private String exercise;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AnswerType subject;
    @Column(nullable = false)
    private String rightAnswer;
}
