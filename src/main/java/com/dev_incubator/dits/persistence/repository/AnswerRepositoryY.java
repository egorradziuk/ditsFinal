package com.dev_incubator.dits.persistence.repository;


import com.dev_incubator.dits.persistence.entity.AnswerY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepositoryY extends JpaRepository<AnswerY, Long> {
    @Query("from AnswerY where id = ?1")
    AnswerY getCorrectByDescription(Long id);
}
