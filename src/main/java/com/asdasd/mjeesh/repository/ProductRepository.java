package com.asdasd.mjeesh.repository;

import com.asdasd.mjeesh.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);                               // C-create

    Optional<Product> findById(Long id);                         // R-read

    List<Product> findAll();                                     // R

    List<Product> findAllByProducerId(Long producerId);          // R

    List<Product> findAllByProducerName(String producerName);    // R

//    void update(Product product);                                // U-update

    void deleteById(Long id);                                    // D-delete
}
