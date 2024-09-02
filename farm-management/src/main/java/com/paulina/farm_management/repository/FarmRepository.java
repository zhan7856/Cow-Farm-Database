package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FarmRepository extends JpaRepository<Farm, Integer> {
}
