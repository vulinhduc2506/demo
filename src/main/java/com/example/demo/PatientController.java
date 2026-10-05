package com.example.demo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    public final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@Valid @RequestBody PatientCreateRequest request) {
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatient() {
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PatientResponse>> findPatientByName(@PathVariable String name) {
        return ResponseEntity.ok(patientService.searchPatient(name));
    }
}
