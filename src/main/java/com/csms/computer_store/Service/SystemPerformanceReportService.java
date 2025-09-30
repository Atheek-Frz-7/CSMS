package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.SystemPerformanceReport;
import com.csms.computer_store.Repository.SystemPerformanceReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SystemPerformanceReportService {

    private final SystemPerformanceReportRepository reportRepo;

    public SystemPerformanceReportService(SystemPerformanceReportRepository reportRepo) {
        this.reportRepo = reportRepo;
    }

    public SystemPerformanceReport createReport(SystemPerformanceReport report) {
        return reportRepo.save(report);
    }

    public Optional<SystemPerformanceReport> getReportById(Long id) {
        return reportRepo.findById(id);
    }

    public List<SystemPerformanceReport> getReportsByDateRange(LocalDate start, LocalDate end) {
        return reportRepo.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(start, end);
    }

    public List<SystemPerformanceReport> getReportsByTechnician(String generatedBy) {
        return reportRepo.findByGeneratedBy(generatedBy);
    }

    public List<SystemPerformanceReport> getHighCpuReports(double threshold) {
        return reportRepo.findByCpuUsageGreaterThan(threshold);
    }

    public List<SystemPerformanceReport> getErrorReports(int minErrors) {
        return reportRepo.findByErrorCountGreaterThan(minErrors);
    }
}
