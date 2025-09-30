package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "finance_payments")
public class FinancePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private FinanceOrder order;

    private double amount;

    private String method;  // e.g., CARD, CASH, BANK_TRANSFER

    private LocalDateTime paidAt;

    private String receivedBy;

    @Column(name = "payment_status")
    private String paymentStatus; // e.g., PENDING, COMPLETED, FAILED

    // Getters & Setters
    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }
    public FinanceOrder getOrder() { return order; }
    public void setOrder(FinanceOrder order) { this.order = order; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }
    public String getReceivedBy() { return receivedBy; }
    public void setReceivedBy(String receivedBy) { this.receivedBy = receivedBy; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
