package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.Answer;

import java.util.List;

public interface AnswerServiceY {
    Answer getCorrectByDescription(Long id);

    //AA

    Answer getById(long id);

    List<Answer> findAll();

    List<Answer> getAnswerByQuestion(Long id);

    void update(Answer answer);

    void add(Answer answer);

    void delete(long id);
}
