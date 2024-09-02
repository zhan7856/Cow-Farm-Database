package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.MilkingMachine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MilkingMachineRepository extends JpaRepository<MilkingMachine, Integer> {
}
