package at.refugeescode.diagnose_room.endpoint;

import at.refugeescode.diagnose_room.controller.DrHouse;
import at.refugeescode.diagnose_room.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
public class DiagnoseEndpoint {

    private RestTemplate restTemplate;
    private DrHouse drHouse;

    @Value("${nursery.url}")
    private String nurseryUrl;

    public DiagnoseEndpoint(RestTemplate restTemplate, DrHouse drHouse) {
        this.restTemplate = restTemplate;
        this.drHouse = drHouse;
    }

    @PostMapping
    void getPatient(@RequestBody Patient patient) {
        Patient drHouseDiagnosis = drHouse.diagnose(patient);
        restTemplate.postForEntity(nurseryUrl, drHouseDiagnosis, Patient.class);
    }
}
