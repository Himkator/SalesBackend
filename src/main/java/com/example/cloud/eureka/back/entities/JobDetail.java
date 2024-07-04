package com.example.cloud.eureka.back.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="jobDetails")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobType;
    private String jobSource;
    private String jobDescription;

    @OneToOne
    @JoinColumn
    private ClientDetail clientDetail;
}
