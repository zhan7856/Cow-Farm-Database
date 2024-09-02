package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Tank;
import com.paulina.farm_management.service.TankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tank")
@RequiredArgsConstructor
public class TankController {

    private TankService tankService;

    @RequestMapping("/add")
    public void addTank(Tank tank) {
        tankService.addTank(tank);
    }
}
