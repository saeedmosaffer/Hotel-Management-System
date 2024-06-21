package edu.birzeit.saeedmosaffer.Hotel_Management_System.controllers.Version2_QueryParameterVersioning;

import edu.birzeit.saeedmosaffer.Hotel_Management_System.entity.Invoice;
import edu.birzeit.saeedmosaffer.Hotel_Management_System.services.interfaces.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceRestControllerV2 {

    private final InvoiceService invoiceService;

    @PostMapping(params = "version=2")
    public ResponseEntity<Invoice> createInvoice(@RequestParam("version") String version, @RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.createInvoice(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", params = "version=2")
    public ResponseEntity<Invoice> getInvoiceById(@RequestParam("version") String version, @PathVariable("id") Long invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        return invoice != null ? new ResponseEntity<>(invoice, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(params = "version=2")
    public ResponseEntity<List<Invoice>> getAllInvoices(@RequestParam("version") String version) {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", params = "version=2")
    public ResponseEntity<Invoice> updateInvoice(@RequestParam("version") String version, @PathVariable("id") Long invoiceId, @RequestBody Invoice invoice) {
        invoice.setInvoiceId(invoiceId);
        Invoice updatedInvoice = invoiceService.updateInvoice(invoice);
        return updatedInvoice != null ? new ResponseEntity<>(updatedInvoice, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}", params = "version=2")
    public ResponseEntity<String> deleteInvoice(@RequestParam("version") String version, @PathVariable("id") Long invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
        return new ResponseEntity<>("Invoice successfully deleted!", HttpStatus.OK);
    }
}
