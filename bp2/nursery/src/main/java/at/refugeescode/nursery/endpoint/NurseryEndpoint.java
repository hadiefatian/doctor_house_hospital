package at.refugeescode.nursery.endpoint;

import at.refugeescode.nursery.controller.Nurse;
import at.refugeescode.nursery.persitence.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
public class NurseryEndpoint {

    @Value("${accountancy.url}")
    String accountancyUrl;

    private RestTemplate restTemplate;
    private Nurse nurse;

    public NurseryEndpoint(RestTemplate restTemplate, Nurse nurse) {
        this.restTemplate = restTemplate;
        this.nurse = nurse;
    }

    @PostMapping
    void getPatient(@RequestBody Patient patient) {
        Patient curedPatient = nurse.treat(patient);
        //restTemplate.postForEntity(accountancyUrl, patient, Patient.class);
        System.out.println(curedPatient);
    }
}
