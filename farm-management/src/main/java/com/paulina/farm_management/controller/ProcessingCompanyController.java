package com.paulina.farm_management.controller;

import com.paulina.farm_management.repository.ProcessingCompanyRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/processingcompany")
public class ProcessingCompanyController {

    private ProcessingCompanyRepository processingCompanyRepository;
}
