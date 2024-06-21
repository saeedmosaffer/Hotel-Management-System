package edu.birzeit.saeedmosaffer.Hotel_Management_System.controllers.Version1_URLPathVersioning;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Invoice;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/invoices")
public class InvoiceRestControllerV1 {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.createInvoice(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        return invoice != null ? new ResponseEntity<>(invoice, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") Long invoiceId, @RequestBody Invoice invoice) {
        invoice.setInvoiceId(invoiceId);
        Invoice updatedInvoice = invoiceService.updateInvoice(invoice);
        return updatedInvoice != null ? new ResponseEntity<>(updatedInvoice, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable("id") Long invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
        return new ResponseEntity<>("Invoice successfully deleted!", HttpStatus.OK);
    }
}

