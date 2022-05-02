package com.asdasd.mjeesh.service.product;

import com.asdasd.mjeesh.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    List<Product> findAllByProducerId(Long id);

    List<Product> findAllByProducerName(String producerName);

    boolean delete(Long id);
}
