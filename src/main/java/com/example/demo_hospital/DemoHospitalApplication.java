package com.example.demo_hospital;

import com.example.demo_hospital.entities.*;
import com.example.demo_hospital.repositories.ConsultationRepository;
import com.example.demo_hospital.repositories.MedecinRepository;
import com.example.demo_hospital.repositories.PatientRepository;
import com.example.demo_hospital.repositories.RenderVousRepository;
import com.example.demo_hospital.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoHospitalApplication   {

    public static void main(String[] args) {
        SpringApplication.run(DemoHospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService HospitalService){
         return args -> {
            for (int i = 0; i < 10 ; i++){
                HospitalService.savePatient(
                        new Patient(null,"Patient "+i,
                                    new Date(), Math.random()>0.5?true:false,null));
            }

             for (int i = 0; i < 5 ; i++){
                 HospitalService.saveMedecin(
                         new Medecin(null,"Medcine"+i,
                                 "Medcine"+(i*2)+"@mail.com", "Specialité : "+i,null));
             }

             //Patient patient = patientRepository.findById(1L).orElse(null);
             Patient patient1 = HospitalService.findPatByName("Patient 1");

             Medecin medecin = HospitalService.findMedByName("Medcine4");

             RenderVous renderVous = new RenderVous();
                renderVous.setDate(new Date());
                renderVous.setStatus(StatusRDV.PENDING);
                renderVous.setPatient(patient1);
                renderVous.setMedecin(medecin);
             HospitalService.saveRenderVous(renderVous);

             RenderVous renderVous1 = HospitalService.findRVById(1L);
             Consultation consultation = new Consultation();
                consultation.setDateConsultation(new Date());
                consultation.setRapport("Rapport de la consulation ....");
                consultation.setRenderVous(renderVous1);
             HospitalService.saveConsultation(consultation);
         };
    }
}
