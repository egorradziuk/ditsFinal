package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.AnswerY;

public interface AnswerServiceY {
    AnswerY getCorrectByDescription(Long id);
}
