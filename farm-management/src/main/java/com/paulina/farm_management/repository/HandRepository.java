package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.Hand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HandRepository extends JpaRepository<Hand, Integer> {
}
