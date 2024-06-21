package edu.birzeit.saeedmosaffer.Hotel_Management_System.repository;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}