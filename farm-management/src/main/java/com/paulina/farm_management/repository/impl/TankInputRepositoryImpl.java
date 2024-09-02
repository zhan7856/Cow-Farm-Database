package com.paulina.farm_management.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class TankInputRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;
}
