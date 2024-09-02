package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.TransportCompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transportcompany")
public class TransportCompanyController {

    private TransportCompanyService transportCompanyService;
}
