package edu.birzeit.saeedmosaffer.Hotel_Management_System.services.implementation;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Invoice;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.repository.InvoiceRepository;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice existingInvoice = invoiceRepository.findById(invoice.getInvoiceId()).orElse(null);
        if (existingInvoice != null) {
            existingInvoice.setReservation(invoice.getReservation());
            existingInvoice.setAmount(invoice.getAmount());
            existingInvoice.setIssueDate(invoice.getIssueDate());
            existingInvoice.setPaymentStatus(invoice.getPaymentStatus());
            return invoiceRepository.save(existingInvoice);
        }
        return null;
    }

    @Override
    public void deleteInvoice(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }
}
