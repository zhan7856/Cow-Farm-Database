package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.ProcessingCompany;
import com.paulina.farm_management.service.ProcessingCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/processingcompany")
@RequiredArgsConstructor
public class ProcessingCompanyController {

    private ProcessingCompanyService processingCompanyService;

    @RequestMapping("/add")
    public void addProcessingCompany(ProcessingCompany processingCompany) {
        processingCompanyService.addProcessingCompany(processingCompany);
    }
}
