package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.Literature;
import com.dev_incubator.dits.persistence.repository.LiteratureRepository;
import com.dev_incubator.dits.service.interfaces.LiteratureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LiteratureServiceImpl implements LiteratureService {

    private LiteratureRepository literatureRepository;


    @Override
    public List<Literature> findAll() {
        return null;
    }


    @Override
    public Literature getById(long id) {
        return literatureRepository.getById(id);
    }

    @Override
    public void add(Literature literature) {
        literatureRepository.save(literature);
    }

    @Override
    public void update(Literature literature) {
        literatureRepository.save(literature);
    }

    @Override
    public void delete(long id) {
        literatureRepository.deleteById(id);
    }
}
