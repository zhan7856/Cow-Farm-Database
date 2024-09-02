package com.paulina.farm_management.data_model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Feed {

    @ManyToOne
    @JoinColumn(referencedColumnName = "farm_id")
    int farm_id;

    int lbs;

    @Column(length = 255)
    String kind;

}
