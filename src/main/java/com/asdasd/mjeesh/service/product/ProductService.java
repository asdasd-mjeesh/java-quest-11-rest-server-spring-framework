package com.asdasd.mjeesh.service.product;

import com.asdasd.mjeesh.model.Product;
import com.asdasd.mjeesh.model.dto.ProductFilter;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll(Integer pageNo);

    List<Product> findAllByProducerId(Long id, Integer pageNo);

    List<Product> findAllByProducerName(String producerName, Integer pageNo);

    List<Product> findByFilter(ProductFilter filter, Integer pageNo);

    boolean delete(Long id);
}
