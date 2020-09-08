package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.Answer;
import com.dev_incubator.dits.persistence.entity.Question;

import java.util.List;

public interface QuestionServiceY {
    List<Question> findAll();
    List<Answer> getAnswersByQuestionId(Long id);

    //AA
    Question getById(long id);

    List<Question> getByTestForEdit(long id);

    void add(Question question);

    void update(Question question);

    void delete(Long id);
}
