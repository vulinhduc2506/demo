package com.example.demo;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    @Transactional
    public PatientResponse createPatient(PatientCreateRequest request) {
        Patient patient = new Patient();
        patient.setFullName(request.getFullName());
        patient.setAddress(request.getAddress());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setPatientCode(request.getPatientCode());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setGender(request.getGender());

        patientRepository.save(patient);

        return PatientResponse.builder()
                .patientCode(patient.getPatientCode())
                .fullName(patient.getFullName())
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth())
                .phoneNumber(patient.getPhoneNumber())
                .gender(patient.getGender())
                .build();
    }

    @Override
    public List<PatientResponse> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(patient -> PatientResponse
                .builder()
                .patientCode(patient.getPatientCode())
                .fullName(patient.getFullName())
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .phoneNumber(patient.getPhoneNumber())
                .build()).toList();
    }

    @Override
    public List<PatientResponse> searchPatient(String name) {
        List<Patient> patients = patientRepository.findByName(name);


        return patients.stream().map(patient -> PatientResponse
                .builder()
                .patientCode(patient.getPatientCode())
                .fullName(patient.getFullName())
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .phoneNumber(patient.getPhoneNumber())
                .build()).toList();
    }


}
