package com.csms.computer_store.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("SUPPLIER")
public class Supplier extends Employee {

    private String address;

    private String passwordHash;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Relationships
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<PurchaseRequest> purchaseRequests;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<SupplierPayment> payments;

    // Constructors
    public Supplier() {}

    public Supplier(String userName, String email, String phone, String address, String passwordHash) {
        super(userName, email, phone, "SUPPLIER");
        this.address = address;
        this.passwordHash = passwordHash;
    }

    // Getters & Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<PurchaseRequest> getPurchaseRequests() {
        return purchaseRequests;
    }

    public void setPurchaseRequests(List<PurchaseRequest> purchaseRequests) {
        this.purchaseRequests = purchaseRequests;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<SupplierPayment> getPayments() {
        return payments;
    }

    public void setPayments(List<SupplierPayment> payments) {
        this.payments = payments;
    }
}
