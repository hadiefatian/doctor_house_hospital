package at.refugeescode.accountancy.persistence.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;
    private Double cost;
    private LocalDateTime date;

    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;


    public Invoice(Double cost, LocalDateTime date, Patient patient) {
        this.cost = cost;
        this.date = date;
        this.patient = patient;
    }

    public Invoice() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", cost=" + cost +
                ", date=" + date +
                ", patient=" + patient +
                '}';
    }
}
