package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PatientResponse {
    private String patientCode;

    private String fullName;

    private LocalDate dateOfBirth;

    private Gender gender;

    private String phoneNumber;

    private String address;
}
