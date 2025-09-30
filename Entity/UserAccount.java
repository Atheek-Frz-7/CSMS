package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "it_user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String passwordHash;

    private String role;   // e.g., SALE_MANAGER, CUSTOMER, FINANCE_ACCOUNTANT, IT_TECHNICIAN

    private boolean active = true; // active/inactive account

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    // Audit trail of who created/modified the account
    private String createdBy;
    private String updatedBy;

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
