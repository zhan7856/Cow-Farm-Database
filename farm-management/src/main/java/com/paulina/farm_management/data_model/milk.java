package com.paulina.farm_management.data_model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class milk {

    @Id
    int milk_id;

    int milk_machine;

    int cow;

    LocalDateTime collected_date;

    LocalTime start_time;

    LocalTime end_time;

    int ozs;

}
