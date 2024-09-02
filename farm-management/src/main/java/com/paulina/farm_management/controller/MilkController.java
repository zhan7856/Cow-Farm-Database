package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.MilkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/milk")
public class MilkController {

    private MilkService milkService;
}
