package com.paulina.farm_management.data_model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class maintenance {

    @Id
    int maintenance_id;

    int milking_machine_affected;

    int primary_hand;

    LocalDateTime maintenance_date;

    boolean maintenance_wasSuccess;

}
