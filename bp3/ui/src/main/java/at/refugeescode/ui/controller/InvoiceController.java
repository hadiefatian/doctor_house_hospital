package at.refugeescode.ui.controller;

import at.refugeescode.ui.model.Invoice;
import at.refugeescode.ui.model.LocalInvoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceController {

    private RestTemplate restTemplate;
    @Value("${invoices.url}")
    private String invoicesUrl;
    private DateTimeFormatter formatter;

    public InvoiceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<LocalInvoice> getInvoices() {
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        List<Invoice> invoices = Arrays.asList(restTemplate.getForObject(invoicesUrl, Invoice[].class));
        return invoices.stream()
                .map(invoice -> {
                    LocalInvoice localInvoice = new LocalInvoice();
                    localInvoice.setName(invoice.getPatient().getName());
                    localInvoice.setIllness(invoice.getPatient().getIllness());
                    localInvoice.setCost(invoice.getCost().toString() + " $");
                    localInvoice.setTime(formatter.format(invoice.getDate()).toString());
                    return localInvoice;
                })
                .collect(Collectors.toList());
    }
}
