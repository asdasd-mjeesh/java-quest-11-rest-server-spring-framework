package com.asdasd.mjeesh.service.product;

import com.asdasd.mjeesh.dto.ProductFilter;
import com.asdasd.mjeesh.model.Product;
import com.asdasd.mjeesh.repository.ProductRepository;
import com.asdasd.mjeesh.util.QPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.asdasd.mjeesh.model.QProduct.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    final int DEFAULT_PAGE_SIZE = 10;
    final String DEFAULT_SORT_VALUE = "title";

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll(Integer pageNo) {
        Pageable paging = PageRequest.of(pageNo, DEFAULT_PAGE_SIZE, Sort.by(DEFAULT_SORT_VALUE));
        var executePage = productRepository.findAll(paging);

        if (executePage.hasContent()) {
            return executePage.getContent();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Product> findAllByProducerId(Long id, Integer pageNo) {
        Pageable paging = PageRequest.of(pageNo, DEFAULT_PAGE_SIZE, Sort.by(DEFAULT_SORT_VALUE));
        var executePage = productRepository.findAllByProducerId(id, paging);

        if (executePage.hasContent()) {
            return executePage.getContent();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Product> findAllByProducerName(String producerName, Integer pageNo) {
        Pageable paging = PageRequest.of(pageNo, DEFAULT_PAGE_SIZE, Sort.by(DEFAULT_SORT_VALUE));
        var executePage = productRepository.findAllByProducerName(producerName, paging);

        if (executePage.hasContent()) {
            return executePage.getContent();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Product> findByFilter(
            String title, String producerName, BigDecimal minCost, BigDecimal maxCost, Integer pageNo) {
        var filter = new ProductFilter(title, producerName, minCost, maxCost); // ok.

        var predicate = QPredicates.builder()
                .add(filter.title(), product.title::containsIgnoreCase)
                .add(filter.producerName(), product.producer.name::containsIgnoreCase)
//                .add(filter.minCost(), product.cost::eq)
//                .add(filter.maxCost(), product.cost::eq)
                .buildAnd();

        Pageable paging = PageRequest.of(pageNo, DEFAULT_PAGE_SIZE, Sort.by(DEFAULT_SORT_VALUE));
        var executePage = productRepository.findAll(predicate, paging);

        if (executePage.hasContent()) {
            return executePage.getContent();
        }
        return new ArrayList<>();
    }

    @Override
    public boolean delete(Long id) {
        productRepository.deleteById(id);
        return productRepository.findById(id).isEmpty();
    }
}