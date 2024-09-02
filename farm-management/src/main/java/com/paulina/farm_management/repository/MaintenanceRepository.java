package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}
