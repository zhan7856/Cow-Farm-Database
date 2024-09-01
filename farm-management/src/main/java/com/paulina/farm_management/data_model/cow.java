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
public class cow {
    @Id
    int ear_tag;

    @Column(length = 255)
    String name;

    int farm;
}
