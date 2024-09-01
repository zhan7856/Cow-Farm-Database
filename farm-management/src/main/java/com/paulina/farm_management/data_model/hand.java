package com.paulina.farm_management.data_model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class hand {

    @Id
    int hand_id;

    @Column(length = 255)
    String fname;

    @Column(length = 255)
    String lname;

    int farm;
}
