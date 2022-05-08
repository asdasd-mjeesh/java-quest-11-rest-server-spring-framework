package com.asdasd.mjeesh.model.dto.mapper;

import com.asdasd.mjeesh.model.dto.ProductDto;
import com.asdasd.mjeesh.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("productMapper")
public class ProductMapper implements Mapper<ProductDto, Product> {

    private final ProducerMapper producerMapper;

    @Autowired
    public ProductMapper(ProducerMapper producerMapper) {
        this.producerMapper = producerMapper;
    }

    @Override
    public ProductDto map(Product fromObject) {
        return new ProductDto(
                fromObject.getId(),
                fromObject.getTitle(),
                fromObject.getCost(),
                fromObject.getShelfLife(),
                producerMapper.map(fromObject.getProducer())
        );
    }

    @Override
    public List<ProductDto> map(List<Product> fromCollection) {
        return fromCollection.stream()
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getTitle(),
                        product.getCost(),
                        product.getShelfLife(),
                        producerMapper.map(product.getProducer())))
                .toList();
    }
}
