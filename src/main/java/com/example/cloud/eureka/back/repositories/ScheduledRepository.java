package com.example.cloud.eureka.back.repositories;

import com.example.cloud.eureka.back.entities.Scheduled;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledRepository extends JpaRepository<Scheduled, Long> {
}
