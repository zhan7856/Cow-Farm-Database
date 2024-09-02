package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.MilkingMachineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/milkingmachine")
public class MilkingMachineController {

    private MilkingMachineService milkingMachineService;
}
