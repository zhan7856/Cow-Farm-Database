package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.CowService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cow")
public class CowController {

    private CowService cowService;

}
