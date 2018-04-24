package at.refugeescode.diagnose_room.controller;

import at.refugeescode.diagnose_room.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DrHouseTest {

    @Autowired
    private DrHouse drHouse;

    @Test
    void diagnose() {

        Patient patient = createPatient("Test Patient");
        Patient diagnosed = drHouse.diagnose(patient);
        assertNotNull(diagnosed);
        assertEquals("lactose intolerance", diagnosed.getIllness());
    }

    private Patient createPatient(String name) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setSymptoms(
                Stream.of("diarrhoea", "flatulence").collect(Collectors.toList())
        );
        return patient;
    }

    @Test
    void diagnoseNotFound() {
        Patient patient = createPatient("Test Patient");
        patient.setSymptoms(Stream.of("something unknown").collect(Collectors.toList()));
        Patient diagnosed = drHouse.diagnose(patient);
        assertNotNull(diagnosed);
        assertEquals("Lupus", diagnosed.getIllness());
    }
}