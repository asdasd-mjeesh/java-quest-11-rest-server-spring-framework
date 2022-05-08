package com.asdasd.mjeesh.model.dto.mapper;

import com.asdasd.mjeesh.model.dto.ProducerDto;
import com.asdasd.mjeesh.model.Producer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("producerMapper")
public class ProducerMapper implements Mapper<ProducerDto, Producer> {

    @Override
    public ProducerDto map(Producer fromObject) {
        return new ProducerDto(
                fromObject.getId(),
                fromObject.getName(),
                fromObject.getContacts()
        );
    }

    @Override
    public List<ProducerDto> map(List<Producer> fromCollection) {
        return fromCollection.stream()
                .map(producer -> new ProducerDto(
                        producer.getId(),
                        producer.getName(),
                        producer.getContacts()))
                .toList();
    }
}
