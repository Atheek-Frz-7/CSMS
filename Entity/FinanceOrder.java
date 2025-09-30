package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "finance_orders")
public class FinanceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long customerId;   // FK → Customer (if needed)

    private LocalDate orderDate;

    @Column(name = "order_status")
    private String orderStatus;   // e.g., PENDING, COMPLETED

    private String paymentStatus;  // e.g., PAID, UNPAID

    private double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<FinanceOrderDetail> orderDetails;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<FinancePayment> payments;

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public List<FinanceOrderDetail> getOrderDetails() { return orderDetails; }
    public void setOrderDetails(List<FinanceOrderDetail> orderDetails) { this.orderDetails = orderDetails; }
    public List<FinancePayment> getPayments() { return payments; }
    public void setPayments(List<FinancePayment> payments) { this.payments = payments; }
}
