package at.refugeescode.diagnose_room.controller;

import at.refugeescode.diagnose_room.model.Patient;
import at.refugeescode.diagnose_room.parser.IllnessEncyclopedia;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class DrHouse {

    private IllnessEncyclopedia illnessEncyclopedia;

    public DrHouse(IllnessEncyclopedia illnessEncyclopedia) {
        this.illnessEncyclopedia = illnessEncyclopedia;
    }

    public Patient diagnose(Patient patient) {
        Map<String, List<String>> illnesses = illnessEncyclopedia.getIllnesses();
        List<String> patientSymptoms = patient.getSymptoms();

        String illness = figureOutIllness(illnesses, patientSymptoms);
        patient.setIllness(illness);
        return patient;
    }

    // entrySet returns a set view of the mappings
    private String figureOutIllness(Map<String, List<String>> illnesses, List<String> patientSymptoms) {
        return illnesses.entrySet().stream()
                .filter(e -> e.getValue().containsAll(patientSymptoms))
                .map(e -> e.getKey())
                .findFirst().orElse("Lupus");
    }
}
