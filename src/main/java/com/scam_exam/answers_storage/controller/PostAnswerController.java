package com.scam_exam.answers_storage.controller;

import com.scam_exam.answers_storage.model.Answer;
import com.scam_exam.answers_storage.service.AnswersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
@CrossOrigin
@AllArgsConstructor
public class PostAnswerController {
    private final AnswersService service;

    @PostMapping("/save_one")
    public String create(@ModelAttribute("answer") Answer answer) {
        service.saveOne(answer);

        return "redirect:/get/new";
    }

}
