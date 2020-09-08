package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.Literature;

import java.util.List;

public interface LiteratureService {
    List<Literature> findAll();

    Literature getById(long id);

    void add(Literature literature);

    void update(Literature literature);

    void delete(long id);
}
