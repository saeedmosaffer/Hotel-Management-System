package edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice createInvoice(Invoice invoice);
    Invoice getInvoiceById(Long invoiceId);
    List<Invoice> getAllInvoices();
    Invoice updateInvoice(Invoice invoice);
    void deleteInvoice(Long invoiceId);
}

