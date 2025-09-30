package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.FinanceInvoice;
import com.csms.computer_store.Entity.FinancePayment;
import com.csms.computer_store.Entity.FinanceSalesReport;
import com.csms.computer_store.Service.FinanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    // ----------- Payments -----------
    @GetMapping("/payments/order/{orderId}")
    public List<FinancePayment> getPaymentsByOrder(@PathVariable Long orderId) {
        return financeService.getPaymentsByOrder(orderId);
    }

    @GetMapping("/payments/status/{status}")
    public List<FinancePayment> getPaymentsByStatus(@PathVariable String status) {
        return financeService.getPaymentsByStatus(status);
    }

    // ----------- Invoices -----------
    @PostMapping("/invoices")
    public ResponseEntity<?> createInvoice(@RequestBody FinanceInvoice invoice) {
        try {
            FinanceInvoice savedInvoice = financeService.createInvoice(invoice);
            return ResponseEntity.ok(savedInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating invoice: " + e.getMessage());
        }
    }

    @GetMapping("/invoices/{id}")
    public Optional<FinanceInvoice> getInvoiceById(@PathVariable Long id) {
        return financeService.getInvoiceById(id);
    }

    @GetMapping("/invoices/type/{type}")
    public List<FinanceInvoice> getInvoicesByType(@PathVariable String type) {
        return financeService.getInvoicesByType(type);
    }

    // ----------- Sales Reports -----------
    @PostMapping("/reports")
    public FinanceSalesReport createReport(@RequestBody FinanceSalesReport report) {
        return financeService.createSalesReport(report);
    }

    @GetMapping("/reports/{id}")
    public Optional<FinanceSalesReport> getReportById(@PathVariable Long id) {
        return financeService.getReportById(id);
    }

    @GetMapping("/reports")
    public List<FinanceSalesReport> getReportsBetweenDates(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return financeService.getReportsBetweenDates(start, end);
    }

    @GetMapping
    public String financeApiRoot() {
        return "Finance API is available.";
    }
}
