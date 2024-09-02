package com.paulina.farm_management.repository.impl;

import com.paulina.farm_management.data_model.Feed;
import com.paulina.farm_management.repository.FeedRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class FeedRepositoryImpl implements FeedRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Feed addFeed(Feed feed) {
        entityManager.persist(feed);
        return feed;
    }

}
