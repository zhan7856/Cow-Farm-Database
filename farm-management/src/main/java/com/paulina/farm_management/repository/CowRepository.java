package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.Cow;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CowRepository extends JpaRepository<Cow, Integer> {
}
