package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.SystemPerformanceReport;
import com.csms.computer_store.Service.SystemPerformanceReportService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/it/reports")
public class SystemPerformanceReportController {

    private final SystemPerformanceReportService reportService;

    public SystemPerformanceReportController(SystemPerformanceReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public SystemPerformanceReport createReport(@RequestBody SystemPerformanceReport report) {
        return reportService.createReport(report);
    }

    @GetMapping("/{id}")
    public Optional<SystemPerformanceReport> getReportById(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @GetMapping("/daterange")
    public List<SystemPerformanceReport> getReportsByDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return reportService.getReportsByDateRange(start, end);
    }

    @GetMapping("/technician/{name}")
    public List<SystemPerformanceReport> getReportsByTechnician(@PathVariable String name) {
        return reportService.getReportsByTechnician(name);
    }

    @GetMapping("/highcpu/{threshold}")
    public List<SystemPerformanceReport> getHighCpuReports(@PathVariable double threshold) {
        return reportService.getHighCpuReports(threshold);
    }

    @GetMapping("/errors/{min}")
    public List<SystemPerformanceReport> getErrorReports(@PathVariable int min) {
        return reportService.getErrorReports(min);
    }
}
