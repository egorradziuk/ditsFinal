package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.Answer;
import com.dev_incubator.dits.persistence.entity.Question;
import com.dev_incubator.dits.persistence.repository.QuestionRepository;
import com.dev_incubator.dits.service.interfaces.QuestionServiceY;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class QuestionServiceImplY implements QuestionServiceY {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Answer> getAnswersByQuestionId(Long id) {
        return questionRepository.getAnswersByQuestionId(id);
    }
    //AA
    @Override
    public Question getById(long id) {
        return questionRepository.getById(id);
    }

    @Override
    public List<Question> getByTestForEdit(long id) {
        return questionRepository.getByTestForEdit(id);
    }

    @Override
    public void add(Question question) {
        questionRepository.saveAndFlush(question);
    }

    @Override
    public void update(Question question) {
        questionRepository.saveAndFlush(question);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
