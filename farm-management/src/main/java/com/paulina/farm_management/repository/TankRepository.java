package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.Tank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TankRepository extends JpaRepository<Tank, Integer> {
}
