package com.paulina.farm_management.repository.impl;

import com.paulina.farm_management.repository.FeedRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class FeedRepositoryImpl implements FeedRepository {
    @PersistenceContext
    EntityManager entityManager;

}
