package com.asdasd.mjeesh.rest;

import com.asdasd.mjeesh.model.dto.ProducerDto;
import com.asdasd.mjeesh.model.dto.mapper.ProducerMapper;
import com.asdasd.mjeesh.exception_heandling.producer.NoSuchProducerException;
import com.asdasd.mjeesh.exception_heandling.product.NoSuchProductException;
import com.asdasd.mjeesh.model.Producer;
import com.asdasd.mjeesh.service.producer.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public List<ProducerDto> findAll() {
        return producerMapper.map(producerService.findAll());
    }

    @GetMapping("/{pageNo}")
    public List<ProducerDto> findAll(@PathVariable Integer pageNo) {
        return producerMapper.map(producerService.findAll(pageNo));
    }

    @GetMapping("/id/{id}")
    public ProducerDto findById(@PathVariable Long id) {
        var findResult = producerService.findById(id);
        if (Objects.isNull(findResult)) {
            throw new NoSuchProducerException("No such producer with id = " + id);
        }

        return producerMapper.map(findResult);
    }

    @PostMapping("/")
    public ProducerDto addNewProducer(@RequestBody Producer producer) {
        return producerMapper.map(producerService.save(producer));
    }

    @PutMapping("/")
    public ProducerDto updateProducer(@RequestBody Producer producer) {
        return producerMapper.map(producerService.save(producer));
    }

    @DeleteMapping("/{id}")
    public String deleteProducer(@PathVariable Long id) {
        if (!producerService.delete(id)) {
            throw new NoSuchProductException("Database is not exist producer with id = " + id);
        }
        return "producer with id = " + id + " was deleted";
    }
}
