package at.refugeescode.accountancy.controller;

import at.refugeescode.accountancy.parser.TreatmentCosts;
import at.refugeescode.accountancy.persistence.model.Invoice;
import at.refugeescode.accountancy.persistence.model.Patient;
import at.refugeescode.accountancy.persistence.repository.InvoiceRepository;
import at.refugeescode.accountancy.persistence.repository.PatientRepository;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class Accountant {

    private TreatmentCosts treatmentCosts;
    private PatientRepository patientRepository;
    private InvoiceRepository invoiceRepository;
    private Invoice invoice;

    public Accountant(TreatmentCosts treatmentCosts, PatientRepository patientRepository, InvoiceRepository invoiceRepository) {
        this.treatmentCosts = treatmentCosts;
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Patient patient) {

        invoice = new Invoice();

        Map<String, Double> costs = treatmentCosts.getCosts();
        String patientIllness = patient.getIllness();
        Double cost = provideCost(costs, patientIllness);

        invoice.setCost(cost);
        invoice.setDate(LocalDateTime.now());
        Patient savedPatient = patientRepository.save(patient);
        invoice.setPatient(savedPatient);
        invoiceRepository.save(invoice);
    }

    private Double provideCost(Map<String, Double> costs, String patientIllness) {
        return costs.entrySet().stream()
                .filter(e -> e.getKey().contains(patientIllness))
                .map(e -> e.getValue())
                .findFirst().orElse(50.00);
    }

    public List<Invoice> showInvoices() {
        return invoiceRepository.findAll();
    }
}
