package at.refugeescode.nursery.persitence.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document
public class Patient {

    @Id
    private String id;
    private String name;
    private String patientNumber;
    private String illness;
    private List<String> symptoms;
    private String treatment;


    public Patient() {
    }

    public Patient(String name, String patientNumber, String illness, List<String> symptoms, String treatment) {
        this.name = name;
        this.patientNumber = patientNumber;
        this.illness = illness;
        this.symptoms = symptoms;
        this.treatment = treatment;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", patientNumber='" + patientNumber + '\'' +
                ", illness='" + illness + '\'' +
                ", symptoms=" + symptoms +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}

