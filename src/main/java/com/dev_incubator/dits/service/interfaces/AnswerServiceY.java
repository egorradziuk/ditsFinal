package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.Answer;

public interface AnswerServiceY {
    Answer getCorrectByDescription(Long id);
}
