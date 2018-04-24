package at.refugeescode.accountancy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double costOfTreatment;
    private LocalDateTime date;


    public Invoice() {
    }

    public Invoice(String name, Double costOfTreatment, LocalDateTime date) {
        this.name = name;
        this.costOfTreatment = costOfTreatment;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCostOfTreatment() {
        return costOfTreatment;
    }

    public void setCostOfTreatment(Double costOfTreatment) {
        this.costOfTreatment = costOfTreatment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costOfTreatment=" + costOfTreatment +
                ", date=" + date +
                '}';
    }
}
