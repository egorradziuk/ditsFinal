package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.AnswerY;
import com.dev_incubator.dits.persistence.entity.QuestionY;

import java.util.List;

public interface QuestionServiceY {
    List<QuestionY> findAllQuestions();
    List<AnswerY> getAnswersByQuestionId(Long id);
}
