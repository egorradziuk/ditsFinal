package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.AnswerY;
import com.dev_incubator.dits.persistence.entity.QuestionY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepositoryY extends JpaRepository <QuestionY, Long> {
    @Query("from AnswerY where questionY.id = ?1")
    List<AnswerY> getAnswersByQuestionId(Long id);
}
