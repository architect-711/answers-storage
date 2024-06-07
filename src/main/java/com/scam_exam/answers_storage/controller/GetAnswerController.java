package com.scam_exam.answers_storage.controller;

import com.scam_exam.answers_storage.model.Answer;
import com.scam_exam.answers_storage.model.AnswerType;
import com.scam_exam.answers_storage.model.AnswerRequest;
import com.scam_exam.answers_storage.service.AnswersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

@Controller
@RequestMapping("/get")
@CrossOrigin
@AllArgsConstructor
public class GetAnswerController {
    private final AnswersService service;

    @GetMapping("/all/text_match")
    public String findByExerciseMatch(@RequestParam("match") String pattern, @RequestParam("type") AnswerType type, Model model) {
        String decodedURL = (UriUtils.decode(pattern, "UTF-8"));

        model.addAttribute("answers", service.findByPatternAndType(decodedURL, type));

        return "text_matches";
    }

    @GetMapping("/search")
    public String searchAnswer(Model model) {
        model.addAttribute("subjectTypes", AnswerType.values());
        model.addAttribute("answerRequest", new AnswerRequest());

        return "search";
    }

    @GetMapping("/new")
    public String newAnswer(Model model) {
        model.addAttribute("answer", new Answer());
        model.addAttribute("types", AnswerType.values());

        return "create_answer";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("answers", service.findAll());

        return "text_matches";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id, Model model) {
        model.addAttribute(service.findById(Long.valueOf(id)));

        return "answer";
    }
}
