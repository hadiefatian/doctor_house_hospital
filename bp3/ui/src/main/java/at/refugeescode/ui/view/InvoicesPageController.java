package at.refugeescode.ui.view;

import at.refugeescode.ui.controller.InvoiceController;
import at.refugeescode.ui.model.LocalInvoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoicesPageController {

    private InvoiceController invoiceController;

    public InvoicesPageController(InvoiceController invoiceController) {
        this.invoiceController = invoiceController;
    }

    // Gets the info for the page
    @ModelAttribute("invoices")
    List<LocalInvoice> showAll() {
        return invoiceController.getInvoices();
    }

    // Returns the html page
    @GetMapping
    String page() {
        return "invoices";
    }
}
