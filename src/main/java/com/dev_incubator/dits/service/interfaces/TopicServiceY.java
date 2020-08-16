package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.TopicY;

import java.util.List;

public interface TopicServiceY {
    List<TopicY> findAll();
    List<String> findTestsByTopicY(String name);
}
