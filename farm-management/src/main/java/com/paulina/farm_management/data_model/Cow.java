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
public class Cow {
    @Id
    int ear_tag;

    @Column(length = 255)
    String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "farm_id")
    int farm;
}
