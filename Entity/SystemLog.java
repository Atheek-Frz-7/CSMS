package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "it_system_logs")
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private String title;

    @Column(length = 2000)
    private String description;

    private String severity;   // LOW, MEDIUM, HIGH, CRITICAL

    private String status;     // OPEN, IN_PROGRESS, RESOLVED, CLOSED

    private String reportedBy; // stakeholder who reported

    private String assignedTo; // IT Technician handling

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @Column(length = 2000)
    private String response; // IT Technician reply/notes

    // Getters and Setters
    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }
}
