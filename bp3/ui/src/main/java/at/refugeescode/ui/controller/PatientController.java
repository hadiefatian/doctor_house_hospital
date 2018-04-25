package at.refugeescode.ui.controller;

import at.refugeescode.ui.model.LocalPatient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientController {

    private RestTemplate restTemplate;
    @Value("${admission.url}")
    private String admissionUrl;

    public PatientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // We post name & symptoms into the ui and it sends it to the admission app
    public void addNewPatient(LocalPatient localPatient) {
        restTemplate.postForObject(admissionUrl, localPatient, LocalPatient.class);
    }
}
