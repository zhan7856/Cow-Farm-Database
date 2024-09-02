package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Feed;
import com.paulina.farm_management.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedService {

    private FeedRepository feedRepository;

    public Feed addFeed(Feed feed) {
        return feedRepository.addFeed(feed);
    }

}
