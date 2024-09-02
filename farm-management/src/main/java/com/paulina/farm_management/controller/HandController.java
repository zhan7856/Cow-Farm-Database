package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Hand;
import com.paulina.farm_management.service.HandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hand")
@RequiredArgsConstructor
public class HandController {

    private HandService handService;

    @RequestMapping("/add")
    public void addHand(Hand hand) {
        handService.addHand(hand);
    }
}
