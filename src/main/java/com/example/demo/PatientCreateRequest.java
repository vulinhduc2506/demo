package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreateRequest {

    @NotBlank(message = "ko duoc de trong")
    private String patientCode;

    @NotBlank(message = "ko duoc de trong")
    private String fullName;

    private LocalDate dateOfBirth;
    private Gender gender;

    private String phoneNumber;

    private String address;
}
