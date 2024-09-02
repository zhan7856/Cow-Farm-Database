package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.Milk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MilkRepository extends JpaRepository<Milk, Integer> {
}
