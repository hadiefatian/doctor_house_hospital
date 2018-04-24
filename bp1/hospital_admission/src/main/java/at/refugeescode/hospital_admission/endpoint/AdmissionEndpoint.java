package at.refugeescode.hospital_admission.endpoint;

import at.refugeescode.hospital_admission.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class AdmissionEndpoint {

    @Value("${diagnoseroom.url}")
    String diagnoseRoomUrl;
    private RestTemplate restTemplate;

    public AdmissionEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    void getPatient(@RequestBody Patient patient) {
        patient.setPatientNumber(UUID.randomUUID().toString());
        restTemplate.postForEntity(diagnoseRoomUrl, patient, Void.class);
    }
}
