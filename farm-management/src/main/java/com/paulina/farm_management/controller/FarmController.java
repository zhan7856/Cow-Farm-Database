package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Farm;
import com.paulina.farm_management.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farm")
@RequiredArgsConstructor
public class FarmController {

    private FarmService farmService;

    @RequestMapping("/add")
    public void addFarm(Farm farm) {
        farmService.addFarm(farm);
    }
}
