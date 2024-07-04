package com.example.cloud.eureka.back.repositories;

import com.example.cloud.eureka.back.entities.ServiceLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceLocationRepository extends JpaRepository<ServiceLocation, Long> {
}
