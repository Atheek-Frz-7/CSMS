package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.FinanceSalesReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

// ----------------- FinanceSalesReport -----------------
public interface FinanceSalesReportRepository extends JpaRepository<FinanceSalesReport, Long> {
    List<FinanceSalesReport> findByStartDateAfterAndEndDateBefore(LocalDate start, LocalDate end);
}
