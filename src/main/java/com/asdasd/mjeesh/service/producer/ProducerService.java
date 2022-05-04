package com.asdasd.mjeesh.service.producer;

import com.asdasd.mjeesh.model.Producer;

import java.util.List;

public interface ProducerService {

    Producer save(Producer producer);

    Producer findById(Long id);

    List<Producer> findAll(Integer pageNo);

    boolean delete(Long id);
}

