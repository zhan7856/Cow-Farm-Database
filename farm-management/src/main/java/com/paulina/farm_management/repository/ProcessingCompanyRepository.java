package com.paulina.farm_management.repository;

import com.paulina.farm_management.data_model.ProcessingCompany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessingCompanyRepository extends JpaRepository<ProcessingCompany, Integer> {
}
