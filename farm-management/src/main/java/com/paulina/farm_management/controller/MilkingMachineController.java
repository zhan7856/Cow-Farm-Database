package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.MilkingMachine;
import com.paulina.farm_management.service.MilkingMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/milkingmachine")
@RequiredArgsConstructor
public class MilkingMachineController {

    private MilkingMachineService milkingMachineService;

    @RequestMapping("/add")
    public void addMilkingMachine(MilkingMachine milkingMachine) {
        milkingMachineService.addMilkingMachine(milkingMachine);
    }
}
