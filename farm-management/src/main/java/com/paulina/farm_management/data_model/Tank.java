package com.paulina.farm_management.data_model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Tank {

    @Id
    int tank_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "farm_id")
    int farm;

    LocalDate purchase;

    LocalDate retired;



}
