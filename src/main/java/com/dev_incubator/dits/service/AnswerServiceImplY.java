package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.AnswerY;
import com.dev_incubator.dits.persistence.repository.AnswerRepositoryY;
import com.dev_incubator.dits.service.interfaces.AnswerServiceY;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AnswerServiceImplY implements AnswerServiceY {

    private final AnswerRepositoryY answerRepositoryY;

    @Override
    public AnswerY getCorrectByDescription(Long id) {
        return answerRepositoryY.getCorrectByDescription(id);
    }
}
