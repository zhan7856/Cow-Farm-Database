package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Maintenance;
import com.paulina.farm_management.repository.MaintenanceRepository;
import com.sun.tools.javac.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;

    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
}
