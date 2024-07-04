package com.example.cloud.eureka.back.factories;

import com.example.cloud.eureka.back.dto.AllDTO;
import com.example.cloud.eureka.back.entities.ClientDetail;
import com.example.cloud.eureka.back.entities.JobDetail;
import com.example.cloud.eureka.back.entities.Scheduled;
import com.example.cloud.eureka.back.entities.ServiceLocation;
import com.example.cloud.eureka.back.repositories.ClientDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AllDtoFactory {
    private final ClientDetailRepository clientDetailRepository;

    public AllDTO makeDTO(ClientDetail clientDetail,
                          JobDetail jobDetail,
                          Scheduled scheduled,
                          ServiceLocation serviceLocation){
        return AllDTO.builder()
                .clientId(clientDetail.getId())
                .firstName(clientDetail.getFirstName())
                .lastName(clientDetail.getLastName())
                .email(clientDetail.getEmail())
                .phoneNumber(clientDetail.getPhoneNumber())
                .jobType(jobDetail.getJobType())
                .jobSource(jobDetail.getJobSource())
                .jobDescription(jobDetail.getJobDescription())
                .startDate(scheduled.getStartDate())
                .startTime(scheduled.getStartTime())
                .endTime(scheduled.getEndTime())
                .testSelect(scheduled.getTestSelect())
                .address(serviceLocation.getAddress())
                .city(serviceLocation.getCity())
                .state(serviceLocation.getState())
                .zipCode(serviceLocation.getZipCode())
                .area(serviceLocation.getArea())
                .build();
    }

    public ClientDetail makeClientFromDTO(AllDTO allDTO){
        return ClientDetail.builder()
                .firstName(allDTO.getFirstName())
                .lastName(allDTO.getLastName())
                .email(allDTO.getEmail())
                .phoneNumber(allDTO.getPhoneNumber())
                .build();
    }

    public JobDetail makeJobFromDTO(AllDTO allDTO, ClientDetail clientDetail){
        return JobDetail.builder()
                .jobType(allDTO.getJobType())
                .jobSource(allDTO.getJobSource())
                .jobDescription(allDTO.getJobDescription())
                .clientDetail(clientDetail)
                .build();
    }

    public Scheduled makeScheduleFromDTO(AllDTO allDTO, ClientDetail clientDetail){
        return Scheduled.builder()
                .startTime(allDTO.getStartTime())
                .startDate(allDTO.getStartDate())
                .endTime(allDTO.getEndTime())
                .testSelect(allDTO.getTestSelect())
                .clientDetail(clientDetail)
                .build();
    }

    public ServiceLocation makeServiceFromDTO(AllDTO allDTO, ClientDetail clientDetail){
        return ServiceLocation.builder()
                .address(allDTO.getAddress())
                .state(allDTO.getState())
                .zipCode(allDTO.getZipCode())
                .city(allDTO.getCity())
                .area(allDTO.getArea())
                .clientDetail(clientDetail)
                .build();
    }
}
