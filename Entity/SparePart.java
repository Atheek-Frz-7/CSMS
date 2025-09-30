package com.csms.computer_store.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "spare_parts")
public class SparePart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    @Column(unique = true, nullable = false)
    private String code;   // unique part code

    @Column(nullable = false)
    private String name;

    private String category;
    private double price;
    private int quantity;
    private int reorderLevel = 5;  // default threshold for low stock alert
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    // Uncomment and implement StockRequest if/when it exists
    // @OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
    // private List<StockRequest> stockRequests;

    // Getters & Setters
    public Long getPartId() { return partId; }
    public void setPartId(Long partId) { this.partId = partId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(int reorderLevel) { this.reorderLevel = reorderLevel; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
