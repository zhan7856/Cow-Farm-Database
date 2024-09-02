package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.FarmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farm")
public class FarmController {

    private FarmService farmService;
}
