package com.csms.computer_store.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_requests")
public class StockRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "part_id", nullable = false)
    private SparePart part;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    private int requestedQuantity;
    private String status; // PENDING, SENT, ACCEPTED, REJECTED
    private LocalDateTime requestDate = LocalDateTime.now();

    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public SparePart getPart() { return part; }
    public void setPart(SparePart part) { this.part = part; }
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public int getRequestedQuantity() { return requestedQuantity; }
    public void setRequestedQuantity(int requestedQuantity) { this.requestedQuantity = requestedQuantity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }
}
