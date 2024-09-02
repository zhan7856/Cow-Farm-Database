package com.paulina.farm_management.repository.impl;

import com.paulina.farm_management.data_model.TankInput;
import com.paulina.farm_management.repository.TankInputRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class TankInputRepositoryImpl implements TankInputRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public TankInput addTankInput(TankInput tankInput) {
        entityManager.persist(tankInput);
        return tankInput;
    }
}
