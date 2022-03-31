package com.example.demo_hospital.repositories;

import com.example.demo_hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String m);
}
