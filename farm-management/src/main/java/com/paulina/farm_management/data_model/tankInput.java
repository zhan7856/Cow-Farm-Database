package com.paulina.farm_management.data_model;

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
public class tankInput {
    int tank;

    int milkAdded;

    LocalDate tankInput_date;

    LocalTime tankInput_time;
}
