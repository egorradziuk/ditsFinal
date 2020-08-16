package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.AnswerY;
import com.dev_incubator.dits.persistence.entity.QuestionY;
import com.dev_incubator.dits.persistence.repository.QuestionRepositoryY;
import com.dev_incubator.dits.service.interfaces.QuestionServiceY;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class QuestionServiceImplY implements QuestionServiceY {

    private final QuestionRepositoryY questionRepositoryY;

    @Override
    public List<QuestionY> findAllQuestions() {
        return questionRepositoryY.findAll();
    }

    @Override
    public List<AnswerY> getAnswersByQuestionId(Long id) {
        return questionRepositoryY.getAnswersByQuestionId(id);
    }
}
