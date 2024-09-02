package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.TankInput;
import com.paulina.farm_management.repository.TankInputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TankInputService {

    private TankInputRepository tankInputRepository;

    public TankInput add(TankInput tankInput) {
        return tankInputRepository.addTankInput(tankInput);
    }
}
