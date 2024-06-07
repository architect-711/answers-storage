package com.scam_exam.answers_storage.repository;

import com.scam_exam.answers_storage.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswersRepository extends JpaRepository<Answer, Long> {

    // IMPORTANT: code below doesn't work
    @Deprecated
    Optional<Answer> findByExercise(String exercise);
    @Deprecated
    boolean existsByExercise(String exercise);
}
