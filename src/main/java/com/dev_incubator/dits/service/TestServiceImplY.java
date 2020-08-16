package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.QuestionY;
import com.dev_incubator.dits.persistence.entity.TestY;
import com.dev_incubator.dits.persistence.repository.TestRepositoryY;
import com.dev_incubator.dits.service.interfaces.TestServiceY;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TestServiceImplY implements TestServiceY {

    private final TestRepositoryY testRepositoryY;

    @Override
    public List<TestY> findAll() {
        return testRepositoryY.findAll();
    }

    @Override
    public List<TestY> findAllTestByTopicYId(Long id) {
        return testRepositoryY.findAllTestByTopicYId(id);
    }

    @Override
    public List<QuestionY> getQuestionsByTestName(String name) {

        return testRepositoryY.getQuestionsByTestName(name);
    }
}
