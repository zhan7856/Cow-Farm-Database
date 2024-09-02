package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Milk;
import com.paulina.farm_management.repository.MilkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MilkService {

    private MilkRepository milkRepository;

    public Milk addMilk(Milk milk) {
        return milkRepository.save(milk);
    }
}
