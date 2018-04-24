package at.refugeescode.accountancy.persistence.repository;

import at.refugeescode.accountancy.persistence.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
}
