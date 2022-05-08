package com.asdasd.mjeesh.service.producer;

import com.asdasd.mjeesh.model.Producer;
import com.asdasd.mjeesh.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    final int DEFAULT_PAGE_SIZE = 10;
    final String DEFAULT_SORT_VALUE = "name";

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public Producer save(Producer producer) {
        return producerRepository.save(producer);
    }

    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public List<Producer> findAll(Integer pageNo) {
        Pageable paging = PageRequest.of(pageNo, DEFAULT_PAGE_SIZE, Sort.by(DEFAULT_SORT_VALUE));
        var executePage = producerRepository.findAll(paging);

        if (executePage.hasContent()) {
            return executePage.getContent();
        }
        return new ArrayList<>();
    }

    @Override
    public Producer findById(Long id) {
        return producerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        producerRepository.deleteById(id);
        return producerRepository.findById(id).isEmpty();
    }
}
