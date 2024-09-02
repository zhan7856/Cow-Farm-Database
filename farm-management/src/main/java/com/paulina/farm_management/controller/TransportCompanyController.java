package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.TransportCompany;
import com.paulina.farm_management.service.TransportCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transportcompany")
@RequiredArgsConstructor
public class TransportCompanyController {

    private TransportCompanyService transportCompanyService;

    @RequestMapping("/add")
    public void addTransportCompany(TransportCompany transportCompany) {
        transportCompanyService.addTransportCompany(transportCompany);
    }
}
