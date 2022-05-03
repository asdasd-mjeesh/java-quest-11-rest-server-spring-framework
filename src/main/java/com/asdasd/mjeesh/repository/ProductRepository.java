package com.asdasd.mjeesh.repository;

import com.asdasd.mjeesh.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {

    Product save(Product product);                               // C-create

    Optional<Product> findById(Long id);                         // R-read

    List<Product> findAll();                                     // R

    Page<Product> findAllByProducerId(Long producerId, Pageable paging);          // R

    Page<Product> findAllByProducerName(String producerName, Pageable paging);    // R

//    void update(Product product);                              // U-update

    void deleteById(Long id);                                    // D-delete
}
