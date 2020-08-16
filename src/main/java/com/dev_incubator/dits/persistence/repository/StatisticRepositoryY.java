package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.QuestionY;
import com.dev_incubator.dits.persistence.entity.StatisticY;
import com.dev_incubator.dits.persistence.entity.UserY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StatisticRepositoryY extends JpaRepository<StatisticY, Long> {
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update StatisticY set correct = :correct where date = :date and " +
            "userY = :user and questionY = :question")
    void changeCorrectValue(@Param("date") Timestamp date,
                            @Param("user") UserY user,
                            @Param("question") QuestionY question,
                            @Param("correct") boolean correct);
    List<StatisticY> findAllByDate(Timestamp date);
    @Query("from StatisticY where date = ?1")
    List<StatisticY> getAllByDate(Timestamp date);
}
