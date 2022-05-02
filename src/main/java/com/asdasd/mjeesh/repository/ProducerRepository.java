package com.asdasd.mjeesh.repository;

import com.asdasd.mjeesh.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Producer save(Producer producer);

    List<Producer> findAll();

    Optional<Producer> findById(Long id);

//    void update(Producer producer);

    void deleteById(Long id);
}
