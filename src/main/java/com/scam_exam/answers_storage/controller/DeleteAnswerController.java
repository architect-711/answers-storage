package com.scam_exam.answers_storage.controller;

import com.scam_exam.answers_storage.service.AnswersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/delete")
@CrossOrigin
@AllArgsConstructor
public class DeleteAnswerController {
    private final AnswersService service;

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, @RequestParam("sw") String secretWord) {
        if (secretWord.equals("DEEP_CUMSHOT")) {
            service.deleteById(id);
        }

        return "redirect:/answers/all";
    }
}
