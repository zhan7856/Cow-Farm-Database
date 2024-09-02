package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.TransportCompany;
import com.paulina.farm_management.repository.TransportCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransportCompanyService {

    private TransportCompanyRepository transportCompanyRepository;

    public TransportCompany addTransportCompany(TransportCompany transportCompany) {
        return transportCompanyRepository.save(transportCompany);
    }
}
