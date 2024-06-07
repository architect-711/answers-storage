package com.scam_exam.answers_storage.service;

import com.scam_exam.answers_storage.model.Answer;
import com.scam_exam.answers_storage.model.AnswerType;
import com.scam_exam.answers_storage.repository.AnswersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswersService {
    private final AnswersRepository repository;

    public List<Answer> findByPatternAndType(String pattern, AnswerType type) {
        return repository.findAll().stream().filter(answer -> answer.getType().equals(type)).filter(answer -> answer.getExercise().contains(pattern)).toList();
    }

    @Transactional
    public Answer saveOne(Answer answer) {
        boolean existsHardWay = !repository.findAll().stream().filter(savedOne -> savedOne.getExercise().equals(answer.getExercise())).toList().isEmpty();
        boolean areFieldsEmpty = answer.getRightAnswer().isEmpty() || answer.getExercise().isEmpty();
        // TODO make it work
        // boolean existsNeededWay = repository.existsByExercise(answer.getExercise());

        if (existsHardWay || areFieldsEmpty) {
            return null;
        }

        return repository.save(answer);
    }

    public Answer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Answer> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
