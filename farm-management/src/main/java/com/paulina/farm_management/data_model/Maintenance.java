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

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Maintenance {

    @Id
    int maintenance_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "milking_machine_id")
    int milking_machine_affected;

    @ManyToOne
    @JoinColumn(referencedColumnName = "hand_id")
    int primary_hand;

    LocalDateTime maintenance_date;

    boolean maintenance_wasSuccess;

}
