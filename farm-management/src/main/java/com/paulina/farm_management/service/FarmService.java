package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Farm;
import com.paulina.farm_management.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmService {

    private FarmRepository farmRepository;

    public Farm addFarm(Farm farm) {
        return farmRepository.save(farm);
    }
}
