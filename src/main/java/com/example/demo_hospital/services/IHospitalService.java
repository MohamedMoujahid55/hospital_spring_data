package com.example.demo_hospital.services;

import com.example.demo_hospital.entities.Consultation;
import com.example.demo_hospital.entities.Medecin;
import com.example.demo_hospital.entities.Patient;
import com.example.demo_hospital.entities.RenderVous;

public interface IHospitalService {
     Patient savePatient(Patient p);
     Medecin saveMedecin(Medecin m);
     RenderVous saveRenderVous(RenderVous rv);
     Consultation saveConsultation(Consultation c);

     Patient findPatByName(String m);
     Medecin findMedByName(String m);
     RenderVous findRVById(Long l);
}
