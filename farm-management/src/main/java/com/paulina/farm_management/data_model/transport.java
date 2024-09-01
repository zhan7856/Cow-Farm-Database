package com.paulina.farm_management.data_model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class transport {

    @Id
    int transport_id;

    int tranport_company_id;

    int processor_id;

    @Column(length = 255)
    String truckNum;

    int fromTank;

    LocalDate transport_date;

    LocalTime transport_time;
}
