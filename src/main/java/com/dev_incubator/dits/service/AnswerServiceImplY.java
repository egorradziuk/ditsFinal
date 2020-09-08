package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.Answer;
import com.dev_incubator.dits.persistence.repository.AnswerRepository;
import com.dev_incubator.dits.service.interfaces.AnswerServiceY;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AnswerServiceImplY implements AnswerServiceY {

    private final AnswerRepository answerRepository;

    @Override
    public Answer getCorrectByDescription(Long id) {
        return answerRepository.getCorrectByDescription(id);
    }

    @Override
    public Answer getById(long id) {
        return answerRepository.getById(id);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> getAnswerByQuestion(Long id) {
        return answerRepository.getAnswersByQuestion(id);
    }

    @Override
    public void add(Answer answer) {
        answerRepository.saveAndFlush(answer);
    }

    @Override
    public void update(Answer answer) {
        answerRepository.saveAndFlush(answer);
    }

    @Override
    public void delete(long id) {
        answerRepository.deleteById(id);
    }
}
