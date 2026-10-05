package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface PatientService {
    PatientResponse createPatient(PatientCreateRequest request);
    List<PatientResponse> getAllPatient();
    List<PatientResponse> searchPatient(String name);
}
