package com.csms.computer_store.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "finance_delivery_items")
public class FinanceDeliveryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryItemId;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private FinanceDelivery delivery;

    private Long partId;

    private int quantity;

    private double unitPrice;

    // Getters & Setters
    public Long getDeliveryItemId() { return deliveryItemId; }
    public void setDeliveryItemId(Long deliveryItemId) { this.deliveryItemId = deliveryItemId; }
    public FinanceDelivery getDelivery() { return delivery; }
    public void setDelivery(FinanceDelivery delivery) { this.delivery = delivery; }
    public Long getPartId() { return partId; }
    public void setPartId(Long partId) { this.partId = partId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}
