package com.paulina.farm_management.data_model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class tank {

    @Id
    int tank_id;

    int farm;

    LocalDate purchase;

    LocalDate retired;



}
