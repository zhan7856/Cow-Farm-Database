package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Cow;
import com.paulina.farm_management.service.CowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cow")
@RequiredArgsConstructor
public class CowController {

    private CowService cowService;

    @PostMapping("/add")
    public void addCow(@RequestBody Cow cow) {
        cowService.addCow(cow);
    }

}
