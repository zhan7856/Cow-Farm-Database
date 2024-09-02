package com.paulina.farm_management.service;

import com.paulina.farm_management.data_model.Transport;
import com.paulina.farm_management.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransportService {

    private TransportRepository transportRepository;

    public Transport addTransport(Transport transport) {
        return transportRepository.save(transport);
    }
}
