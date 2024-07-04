package com.example.cloud.eureka.back.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="serviceLocations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String area;

    @OneToOne
    @JoinColumn
    private ClientDetail clientDetail;
}
