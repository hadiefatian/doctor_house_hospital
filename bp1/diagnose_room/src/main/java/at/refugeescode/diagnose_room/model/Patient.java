package at.refugeescode.diagnose_room.model;

import java.util.List;

public class Patient {

    private String name;
    private String patientNumber;
    private String illness;
    private List<String> symptoms;


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


    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", patientNumber='" + patientNumber + '\'' +
                ", illness='" + illness + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}

