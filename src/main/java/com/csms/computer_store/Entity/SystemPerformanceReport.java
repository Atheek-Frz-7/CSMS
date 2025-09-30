package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "it_performance_reports")
public class SystemPerformanceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String generatedBy; // IT Technician username/id

    @Column(length = 2000)
    private String summaryText;

    private String filePath; // path to exported report (PDF/CSV)

    private LocalDateTime createdAt = LocalDateTime.now();

    // Example metrics
    private double cpuUsage;

    private double memoryUsage;

    private int activeUsers;

    private int errorCount;

    // Getters and Setters
    // ...
}

