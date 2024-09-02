package com.paulina.farm_management.data_model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class milkingMachine {

    @Id
    int milking_machine_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "farm_id")
    int farm;
}
