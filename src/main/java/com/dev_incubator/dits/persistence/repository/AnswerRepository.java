package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    //Y
    @Query("from Answer where id = ?1")
    Answer getCorrectByDescription(Long id);
    //AA
    @Query("FROM Answer a WHERE a.id=:id")
    Answer getById(@Param("id") long id);
    //AA
    @Query("FROM Answer a WHERE a.question.id=:questionId")
    List<Answer> getAnswersByQuestion(@Param("questionId") Long questionId);
}
