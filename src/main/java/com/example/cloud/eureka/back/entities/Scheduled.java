package com.example.cloud.eureka.back.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity(name = "scheduled")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Scheduled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Time startTime;
    private Time endTime;
    private String testSelect;

    @OneToOne
    @JoinColumn
    private ClientDetail clientDetail;
}
