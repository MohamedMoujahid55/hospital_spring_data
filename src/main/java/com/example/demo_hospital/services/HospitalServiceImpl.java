package com.example.demo_hospital.services;

import com.example.demo_hospital.entities.Consultation;
import com.example.demo_hospital.entities.Medecin;
import com.example.demo_hospital.entities.Patient;
import com.example.demo_hospital.entities.RenderVous;
import com.example.demo_hospital.repositories.ConsultationRepository;
import com.example.demo_hospital.repositories.MedecinRepository;
import com.example.demo_hospital.repositories.PatientRepository;
import com.example.demo_hospital.repositories.RenderVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RenderVousRepository renderVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RenderVousRepository renderVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.renderVousRepository = renderVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RenderVous saveRenderVous(RenderVous rv) {
        //rv.setId(UUID.randomUUID().toString());  // Genete unique ID
        return renderVousRepository.save(rv);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }

    @Override
    public Patient findPatByName(String m) {
        return patientRepository.findByName(m);
    }

    @Override
    public Medecin findMedByName(String m) {
        return medecinRepository.findByNom(m);
    }

    @Override
    public RenderVous findRVById(Long l) {
        return renderVousRepository.findById(l).orElse(null);
    }
}
