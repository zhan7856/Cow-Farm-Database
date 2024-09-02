package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.MaintenanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private MaintenanceService maintenanceService;
}
