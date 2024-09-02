package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Cow;
import com.paulina.farm_management.repository.CowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CowService {

    private CowRepository cowRepository;

    public Cow addCow(Cow cow) {
        return cowRepository.save(cow);
    }

}
