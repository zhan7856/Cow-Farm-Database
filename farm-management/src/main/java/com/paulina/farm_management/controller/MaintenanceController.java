package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Maintenance;
import com.paulina.farm_management.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {

    private MaintenanceService maintenanceService;

    @RequestMapping("/add")
    public void addMaintenance(Maintenance maintenance) {
        maintenanceService.addMaintenance(maintenance);
    }
}
