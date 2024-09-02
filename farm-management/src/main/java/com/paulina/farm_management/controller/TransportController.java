package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.TransportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transport")
public class TransportController {

    private TransportService transportService;
}
