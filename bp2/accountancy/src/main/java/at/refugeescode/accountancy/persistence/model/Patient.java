package at.refugeescode.accountancy.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String patientNumber;
    private String name;
    private String illness;
    private String treatment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
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
                ", patientNumber='" + patientNumber + '\'' +
                ", name='" + name + '\'' +
                ", illness='" + illness + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}

