package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Question;
import com.dev_incubator.dits.persistence.entity.Test;
import com.dev_incubator.dits.persistence.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findAllByTopic(Topic topic);

    //Y
    List<Test> findAllTestByTopicId(Long id);
    List<Question> getTestsByTopicName(String topic);
    @Query("select questions from Test where name = ?1")
    List<Question> getQuestionsByTestName(String name);

    void deleteTestById(Long id);

    //AA
    @Query("FROM Test t WHERE t.id=:id")
    Test getById(@Param("id") long id);

    @Query("FROM Test t LEFT JOIN Question q ON t.id=q.test.id WHERE q.id IS NULL AND t.topic.id=:id")
    List<Test> getByTopicId(@Param("id") long id);

    @Query("FROM Test t LEFT JOIN Question q ON t.id=q.test.id WHERE q.id IS NOT  NULL AND t.topic.id=:id GROUP BY t")
    List<Test> getByTopicIdForEdit(@Param("id") long id);
}
