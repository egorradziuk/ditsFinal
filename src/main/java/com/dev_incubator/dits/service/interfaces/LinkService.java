package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.Link;

import java.util.List;

public interface LinkService {

    List<Link> findAll();

    void add(Link link);

    void update(Link link);

    void delete(Long id);
}
