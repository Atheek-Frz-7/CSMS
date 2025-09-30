package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long saleId;

    @Column(name = "sale_date")
    private LocalDate saleDate;

    @Column(name = "total_amount")
    private Double totalAmount;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private SalesStaff staff;

    @Column(name = "customer_id")
    private Long customerId;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<Receipt> receipts;

    // Getters and Setters
    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public SalesStaff getStaff() {
        return staff;
    }

    public void setStaff(SalesStaff staff) {
        this.staff = staff;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }
}
