package com.example.cloud.eureka.back.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllDTO {
    private int statusCode;
    private String message;

    private Long clientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    private String jobType;
    private String jobSource;
    private String jobDescription;

    private Date startDate;
    private Time startTime;
    private Time endTime;
    private String testSelect;

    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String area;
}
