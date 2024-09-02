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
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class tankInput {

    @ManyToOne
    @JoinColumn(referencedColumnName = "tank_id")
    int tank;

    @ManyToOne
    @JoinColumn(referencedColumnName = "milk_id")
    int milkAdded;

    LocalDate tankInput_date;

    LocalTime tankInput_time;
}
