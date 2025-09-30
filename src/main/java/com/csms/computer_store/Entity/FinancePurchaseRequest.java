package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "finance_purchase_requests")
public class FinancePurchaseRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private Long managerId;   // FK → Manager

    private Long supplierId;  // FK → Supplier

    private LocalDate requestDate;

    private String status;    // e.g., PENDING, APPROVED

    private double totalAmount;

    // Getters & Setters
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
