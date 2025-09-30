package com.csms.computer_store.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "finance_sales_reports")
public class FinanceSalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(columnDefinition = "TEXT")
    private String summaryText;

    private String createdBy;   // Name of creator

    private String filePath;  // location of report file

    // Getters & Setters
    public Long getReportId() { return reportId; }
    public void setReportId(Long reportId) { this.reportId = reportId; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getSummaryText() { return summaryText; }
    public void setSummaryText(String summaryText) { this.summaryText = summaryText; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
}
