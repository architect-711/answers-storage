package com.scam_exam.answers_storage.controller;

import com.scam_exam.answers_storage.model.Answer;
import com.scam_exam.answers_storage.service.AnswersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest/get")
@AllArgsConstructor
public class GetRestAnswersController {
    private final AnswersService service;

    @GetMapping("/all")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}

