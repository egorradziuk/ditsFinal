package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.TopicY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepositoryY extends JpaRepository<TopicY, Long> {
    @Query("Select name From TestY Where topicY.name = ?1")
    List<String> findTestsByTopicY(String name);
}
