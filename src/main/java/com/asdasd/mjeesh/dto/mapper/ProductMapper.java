package com.asdasd.mjeesh.dto.mapper;

import com.asdasd.mjeesh.dto.ProductDto;
import com.asdasd.mjeesh.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("productMapper")
public class ProductMapper implements Mapper<ProductDto, Product> {

    @Override
    public ProductDto map(Product fromObject) {
        return new ProductDto(
                fromObject.getId(),
                fromObject.getTitle(),
                fromObject.getCost(),
                fromObject.getShelfLife(),
                fromObject.getProducer()
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
                        product.getProducer()))
                .toList();
    }
}
