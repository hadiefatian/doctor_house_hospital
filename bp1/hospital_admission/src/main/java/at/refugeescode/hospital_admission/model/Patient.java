package at.refugeescode.hospital_admission.model;

import java.util.List;

public class Patient {

    private String patientNumber;
    private String name;
    private List<String> symptoms;


    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "patientNumber='" + patientNumber + '\'' +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}


