package com.asdasd.mjeesh.service.product;

import com.asdasd.mjeesh.model.Producer;
import com.asdasd.mjeesh.model.Product;
import com.asdasd.mjeesh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByProducerId(Long id) {
        return productRepository.findAllByProducerId(id);
    }

    @Override
    public List<Product> findAllByProducerName(String producerName) {
        return productRepository.findAllByProducerName(producerName);
    }

    @Override
    public boolean delete(Long id) {
        productRepository.deleteById(id);
        return productRepository.findById(id).isEmpty();
    }

}