package at.refugeescode.nursery.controller;

import at.refugeescode.nursery.parser.TreatmentEncyclopedia;
import at.refugeescode.nursery.persitence.model.Patient;
import at.refugeescode.nursery.persitence.repository.PatientRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class Nurse {

    private TreatmentEncyclopedia treatmentEncyclopedia;
    private PatientRepository patientRepository;

    public Nurse(TreatmentEncyclopedia treatmentEncyclopedia, PatientRepository patientRepository) {
        this.treatmentEncyclopedia = treatmentEncyclopedia;
        this.patientRepository = patientRepository;
    }

    public Patient treat(Patient patient) {
        Map<String, List<String>> treatments = treatmentEncyclopedia.getTreatments();
        String patientIllness = patient.getIllness();

        String treatment = provideTreatment(treatments, patientIllness);
        patient.setTreatment(treatment);
        patientRepository.save(patient);
        return patient;
    }

    private String provideTreatment(Map<String, List<String>> treatments, String patientIllness) {
        return treatments.entrySet().stream()
                .filter(e -> e.getKey().contains(patientIllness))
                .map(e -> e.getValue().stream().collect(Collectors.joining(", ")))
                .findFirst().orElse("No cure for that...!");
    }
}
