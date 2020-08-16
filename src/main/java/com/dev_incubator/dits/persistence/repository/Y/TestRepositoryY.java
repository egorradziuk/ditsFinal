/*
package com.dev_incubator.dits.persistence.repository.Y;

import com.dev_incubator.dits.persistence.entity.Y.QuestionY;
import com.dev_incubator.dits.persistence.entity.Y.TestY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepositoryY extends JpaRepository<TestY, Long> {
    List<TestY> findAllTestByTopicYId(Long id);

    //    @Query("From Test ts Join ts.topic tp Where tp.id = 1")
    List<QuestionY> getTestsByTopicYName(String topic);
    @Query("select questionsY from TestY where name = ?1")
    List<QuestionY> getQuestionsByTestName(String name);
}
*/
