package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerAwardRepository extends JpaRepository<ProducerAward, Long> {
    List<ProducerAward> findByWinnerTrueOrderByYear();
}
