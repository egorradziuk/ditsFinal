package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.QuestionY;
import com.dev_incubator.dits.persistence.entity.TestY;

import java.util.List;

public interface TestServiceY {
    List<TestY> findAll();
    List<TestY> findAllTestByTopicYId(Long id);
    List<QuestionY> getQuestionsByTestName(String topic);
}
