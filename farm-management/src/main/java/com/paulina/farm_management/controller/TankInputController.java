package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.TankInput;
import com.paulina.farm_management.service.TankInputService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tankinput")
public class TankInputController {

    private TankInputService tankInputService;
}
