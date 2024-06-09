package com.scam_exam.answers_storage.controller;

import com.scam_exam.answers_storage.model.Answer;
import com.scam_exam.answers_storage.model.AnswerRequest;
import com.scam_exam.answers_storage.model.AnswerType;
import com.scam_exam.answers_storage.service.AnswersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/get")
@CrossOrigin
@AllArgsConstructor
public class GetAnswerController {
    private final AnswersService service;

    @GetMapping("/all/text_match")
    public String findByExerciseMatch(@RequestParam("exercise") String exercise, @RequestParam("subject") AnswerType subject, Model model) {
        List<Answer> foundAnswers = service.returnFindByPatternAndTypePage(exercise, subject);

        if (foundAnswers.isEmpty()) {
            model.addAttribute("errorMessage", "No answer found for given pattern. Make sure the type and exercise you are looking for are correct.");

            return "error";
        }
        model.addAttribute("answers", foundAnswers);

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
        model.addAttribute("subjects", AnswerType.values());

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
