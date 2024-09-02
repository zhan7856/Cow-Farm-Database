package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Milk;
import com.paulina.farm_management.data_model.MilkingMachine;
import com.paulina.farm_management.repository.MilkingMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MilkingMachineService {

    private MilkingMachineRepository milkingMachineRepository;

    public MilkingMachine addMilkingMachine(MilkingMachine milkingMachine) {
        return milkingMachineRepository.save(milkingMachine);
    }
}
