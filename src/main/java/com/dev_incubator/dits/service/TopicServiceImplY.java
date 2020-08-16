package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.TopicY;
import com.dev_incubator.dits.persistence.repository.TopicRepositoryY;
import com.dev_incubator.dits.service.interfaces.TopicServiceY;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TopicServiceImplY implements TopicServiceY {

    private final TopicRepositoryY topicRepositoryY;

    @Override
    public List<TopicY> findAll() {
        return topicRepositoryY.findAll();
    }

    @Override
    public List<String> findTestsByTopicY(String name) {
        return topicRepositoryY.findTestsByTopicY(name);
    }
}
