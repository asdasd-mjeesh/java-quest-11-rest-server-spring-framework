package com.asdasd.mjeesh.repository;

import com.asdasd.mjeesh.model.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Producer save(Producer producer);

    Page<Producer> findAll(Pageable paging);

    Optional<Producer> findById(Long id);

//    void update(Producer producer);

    void deleteById(Long id);
}
