package com.paulina.farm_management.data_model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Milk {

    @Id
    int milk_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "milking_machine_id")
    int milk_machine;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ear_tag")
    int cow;

    LocalDateTime collected_date;

    LocalTime start_time;

    LocalTime end_time;

    int ozs;

}
