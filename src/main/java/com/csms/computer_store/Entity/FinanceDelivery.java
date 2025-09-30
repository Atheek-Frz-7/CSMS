package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "finance_deliveries")
public class FinanceDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private FinancePurchaseRequest purchaseRequest;

    private LocalDate deliveryDate;

    private String receivedBy;

    private String status; // e.g., SCHEDULED, RECEIVED

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<FinanceDeliveryItem> deliveryItems;

    // Getters & Setters
    public Long getDeliveryId() { return deliveryId; }
    public void setDeliveryId(Long deliveryId) { this.deliveryId = deliveryId; }
    public FinancePurchaseRequest getPurchaseRequest() { return purchaseRequest; }
    public void setPurchaseRequest(FinancePurchaseRequest purchaseRequest) { this.purchaseRequest = purchaseRequest; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
    public String getReceivedBy() { return receivedBy; }
    public void setReceivedBy(String receivedBy) { this.receivedBy = receivedBy; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<FinanceDeliveryItem> getDeliveryItems() { return deliveryItems; }
    public void setDeliveryItems(List<FinanceDeliveryItem> deliveryItems) { this.deliveryItems = deliveryItems; }
}
