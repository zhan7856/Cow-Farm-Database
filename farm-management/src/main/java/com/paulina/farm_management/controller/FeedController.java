package com.paulina.farm_management.controller;

import com.paulina.farm_management.service.FeedService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
public class FeedController {

    private FeedService feedService;
}
