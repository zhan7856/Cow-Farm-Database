package com.paulina.farm_management.data_model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transport {

    @Id
    int transport_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "transportCompany_id")
    int transport_company_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "processingCompany_id")
    int processor_id;

    @Column(length = 255)
    String truckNum;

    @ManyToOne
    @JoinColumn(referencedColumnName = "tank_id")
    int fromTank;

    LocalDate transport_date;

    LocalTime transport_time;
}
