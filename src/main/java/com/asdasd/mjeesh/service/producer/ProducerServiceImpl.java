package com.asdasd.mjeesh.service.producer;

import com.asdasd.mjeesh.model.Producer;
import com.asdasd.mjeesh.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

}
