package com.example.cloud.eureka.back.repositories;

import com.example.cloud.eureka.back.entities.ClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDetailRepository extends JpaRepository<ClientDetail, Long> {
}
