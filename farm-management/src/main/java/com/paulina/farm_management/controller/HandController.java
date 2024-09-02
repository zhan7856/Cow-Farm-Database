package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.HandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hand")
public class HandController {

    private HandService handService;
}
