package at.refugeescode.accountancy.endpoint;

import at.refugeescode.accountancy.controller.Accountant;
import at.refugeescode.accountancy.persistence.model.Invoice;
import at.refugeescode.accountancy.persistence.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AccountancyEndpoint {

    private Accountant accountant;

    public AccountancyEndpoint(Accountant accountant) {
        this.accountant = accountant;
    }

    @PostMapping("/patients")
    void getPatient(@RequestBody Patient patient) {
        accountant.createInvoice(patient);
    }

    @GetMapping("/invoices")
    List<Invoice> showAll(){
        return accountant.showInvoices();
    }
}
