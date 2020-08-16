package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.UserY;
import com.dev_incubator.dits.persistence.repository.UserRepository;
import com.dev_incubator.dits.persistence.repository.UserRepositoryY;
import com.dev_incubator.dits.service.interfaces.UserServiceY;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImplY implements UserServiceY {

    private final UserRepositoryY userRepositoryY;

    @Override
    public UserY findUserById(Long id) {
        return userRepositoryY.findUserById(id);
    }
}
