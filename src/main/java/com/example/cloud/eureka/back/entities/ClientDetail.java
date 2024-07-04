package com.example.cloud.eureka.back.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="clientDetails")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @OneToOne(mappedBy = "clientDetail")
    private JobDetail jobDetail;

    @OneToOne(mappedBy = "clientDetail")
    private ServiceLocation serviceLocation;

    @OneToOne(mappedBy = "clientDetail")
    private Scheduled scheduled;
}
