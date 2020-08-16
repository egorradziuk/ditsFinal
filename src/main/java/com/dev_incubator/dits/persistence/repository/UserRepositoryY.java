package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.UserY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryY extends JpaRepository<UserY, Long> {
    UserY findUserById(Long id);
}
