package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Hand;
import com.paulina.farm_management.repository.HandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HandService {

    private HandRepository handRepository;

    public Hand addHand(Hand hand) {
        return handRepository.save(hand);
    }
}
