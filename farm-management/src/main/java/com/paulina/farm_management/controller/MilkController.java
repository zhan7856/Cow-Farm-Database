package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Milk;
import com.paulina.farm_management.service.MilkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/milk")
@RequiredArgsConstructor
public class MilkController {

    private MilkService milkService;

    @RequestMapping("/add")
    public void addMilk(Milk milk) {
        milkService.addMilk(milk);
    }
}
