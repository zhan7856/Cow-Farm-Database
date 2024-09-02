package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.ProcessingCompany;
import com.paulina.farm_management.repository.ProcessingCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessingCompanyService {

    private ProcessingCompanyRepository processingCompanyRepository;

    public ProcessingCompany addProcessingCompany(ProcessingCompany processingCompany) {
        return processingCompanyRepository.save(processingCompany);
    }
}
