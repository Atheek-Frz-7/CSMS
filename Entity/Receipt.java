package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Long receiptId;

    @Column(name = "receipt_no", unique = true, nullable = false)
    private String receiptNo;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "paid_date")
    private LocalDate paidDate;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<Payment> payments;

    // Getters and Setters
    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
