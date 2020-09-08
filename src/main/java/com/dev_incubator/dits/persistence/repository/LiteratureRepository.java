package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Long> {
    //AA
    @Query("FROM Literature l WHERE l.id=:id")
    Literature getById(@Param("id") long id);
}
