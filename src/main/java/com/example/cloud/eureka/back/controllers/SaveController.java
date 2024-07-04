package com.example.cloud.eureka.back.controllers;

import com.example.cloud.eureka.back.dto.AllDTO;
import com.example.cloud.eureka.back.entities.ClientDetail;
import com.example.cloud.eureka.back.entities.JobDetail;
import com.example.cloud.eureka.back.entities.Scheduled;
import com.example.cloud.eureka.back.entities.ServiceLocation;
import com.example.cloud.eureka.back.factories.AllDtoFactory;
import com.example.cloud.eureka.back.repositories.ClientDetailRepository;
import com.example.cloud.eureka.back.repositories.JobDetailRepository;
import com.example.cloud.eureka.back.repositories.ScheduledRepository;
import com.example.cloud.eureka.back.repositories.ServiceLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SaveController {
    private final AllDtoFactory allDtoFactory;
    private final ClientDetailRepository clientDetailRepository;
    private final JobDetailRepository jobDetailRepository;
    private final ScheduledRepository scheduledRepository;
    private final ServiceLocationRepository serviceLocationRepository;


    @PostMapping("/createJob")
    public ResponseEntity<AllDTO> createJob(@RequestBody AllDTO allDTO){
        ClientDetail clientDetail=allDtoFactory.makeClientFromDTO(allDTO);
        clientDetail=clientDetailRepository.saveAndFlush(clientDetail);
        JobDetail jobDetail=allDtoFactory.makeJobFromDTO(allDTO, clientDetail);
        jobDetailRepository.saveAndFlush(jobDetail);
        Scheduled scheduled=allDtoFactory.makeScheduleFromDTO(allDTO, clientDetail);
        scheduledRepository.saveAndFlush(scheduled);
        ServiceLocation serviceLocation=allDtoFactory.makeServiceFromDTO(allDTO, clientDetail);
        serviceLocationRepository.saveAndFlush(serviceLocation);
        allDTO=allDtoFactory.makeDTO(clientDetail, jobDetail, scheduled, serviceLocation);
        allDTO.setStatusCode(200);
        allDTO.setMessage("Client job was successfully created");
        return ResponseEntity.ok(allDTO);
    }
}
