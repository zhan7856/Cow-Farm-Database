package com.paulina.farm_management.controller;

import com.paulina.farm_management.data_model.Feed;
import com.paulina.farm_management.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private FeedService feedService;

    @RequestMapping("/add")
    public void addFeed(Feed feed) {
        feedService.addFeed(feed);
    }
}
