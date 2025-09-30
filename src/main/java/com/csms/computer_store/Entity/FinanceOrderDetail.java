package com.csms.computer_store.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "finance_order_details")
public class FinanceOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private FinanceOrder order;

    private Long partId;

    private int quantity;

    private double price;

    // Getters & Setters
    public Long getOrderDetailId() { return orderDetailId; }
    public void setOrderDetailId(Long orderDetailId) { this.orderDetailId = orderDetailId; }
    public FinanceOrder getOrder() { return order; }
    public void setOrder(FinanceOrder order) { this.order = order; }
    public Long getPartId() { return partId; }
    public void setPartId(Long partId) { this.partId = partId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
