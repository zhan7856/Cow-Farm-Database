package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Tank;
import com.paulina.farm_management.repository.TankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TankService {

    private TankRepository tankRepository;

    public Tank addTank(Tank tank) {
        return tankRepository.save(tank);
    }
}
