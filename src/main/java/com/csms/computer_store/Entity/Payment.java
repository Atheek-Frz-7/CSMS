package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "receipt_no", referencedColumnName = "receipt_no")
    private Receipt receipt;

    // Getters and Setters
}
