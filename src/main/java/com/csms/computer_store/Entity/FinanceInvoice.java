package com.csms.computer_store.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "finance_invoices")
public class FinanceInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String invoiceType;  // e.g., SALES, PURCHASE

    private Long relatedOrderId;     // FK → FinanceOrder

    private Long relatedRequestId;   // FK → FinancePurchaseRequest

    private double total;

    private boolean paid;

    // Getters & Setters
    public Long getInvoiceId() { return invoiceId; }
    public void setInvoiceId(Long invoiceId) { this.invoiceId = invoiceId; }
    public String getInvoiceType() { return invoiceType; }
    public void setInvoiceType(String invoiceType) { this.invoiceType = invoiceType; }
    public Long getRelatedOrderId() { return relatedOrderId; }
    public void setRelatedOrderId(Long relatedOrderId) { this.relatedOrderId = relatedOrderId; }
    public Long getRelatedRequestId() { return relatedRequestId; }
    public void setRelatedRequestId(Long relatedRequestId) { this.relatedRequestId = relatedRequestId; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}
