package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.*;
import com.csms.computer_store.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Service
public class FinanceService {

    private final FinancePaymentRepository paymentRepository;
    private final FinanceInvoiceRepository invoiceRepository;
    private final FinanceSalesReportRepository salesReportRepository;

    public FinanceService(FinancePaymentRepository paymentRepository,
                          FinanceInvoiceRepository invoiceRepository,
                          FinanceSalesReportRepository salesReportRepository) {
        this.paymentRepository = paymentRepository;
        this.invoiceRepository = invoiceRepository;
        this.salesReportRepository = salesReportRepository;
    }

    // ----------------- Scenario 1: Past Payments -----------------
    public List<FinancePayment> getPaymentsByOrder(Long orderId) {
        return paymentRepository.findByOrder_OrderId(orderId); // Fixed here
    }

    public List<FinancePayment> getPaymentsByStatus(String paymentStatus) {
        return paymentRepository.findByPaymentStatus(paymentStatus);
    }

    // ----------------- Scenario 2: Invoices -----------------
    public FinanceInvoice createInvoice(FinanceInvoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Optional<FinanceInvoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public List<FinanceInvoice> getInvoicesByType(String type) {
        return invoiceRepository.findByInvoiceType(type);
    }

    // ----------------- Scenario 3: Sales Reports -----------------
    public FinanceSalesReport createSalesReport(FinanceSalesReport report) {
        return salesReportRepository.save(report);
    }

    public Optional<FinanceSalesReport> getReportById(Long id) {
        return salesReportRepository.findById(id);
    }

    public List<FinanceSalesReport> getReportsBetweenDates(LocalDate start, LocalDate end) {
        return salesReportRepository.findByStartDateAfterAndEndDateBefore(start, end);
    }
}
