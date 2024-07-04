package com.example.cloud.eureka.back.repositories;

import com.example.cloud.eureka.back.entities.JobDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDetailRepository extends JpaRepository<JobDetail, Long> {
}
