package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Transport;
import com.paulina.farm_management.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transport")
@RequiredArgsConstructor
public class TransportController {

    private TransportService transportService;

    @RequestMapping("/add")
    public void addTransport(Transport transport) {
        transportService.addTransport(transport);
    }
}
