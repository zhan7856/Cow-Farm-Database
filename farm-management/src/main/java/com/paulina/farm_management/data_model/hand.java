package com.paulina.farm_management.data_model;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(referencedColumnName = "farm_id")
    int farm;
}
