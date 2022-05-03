package com.asdasd.mjeesh.rest;

import com.asdasd.mjeesh.dto.ProducerDto;
import com.asdasd.mjeesh.dto.mapper.ProducerMapper;
import com.asdasd.mjeesh.service.producer.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/producers")
public class ProducerController {
    private final ProducerServiceImpl producerService;
    private final ProducerMapper producerMapper;

    @Autowired
    public ProducerController(ProducerServiceImpl producerService, ProducerMapper producerMapper) {
        this.producerService = producerService;
        this.producerMapper = producerMapper;
    }

    @GetMapping("/{pageNo}")
    public List<ProducerDto> findAll(@PathVariable Integer pageNo) {
        return producerMapper.map(producerService.findAll(pageNo));
    }
}
