package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {

    // Find logs by severity
    List<SystemLog> findBySeverity(String severity);

    // Find logs by status (OPEN, IN_PROGRESS, etc.)
    List<SystemLog> findByStatus(String status);

    // Find logs reported by a stakeholder
    List<SystemLog> findByReportedBy(String reportedBy);

    // Find logs assigned to a specific IT Technician
    List<SystemLog> findByAssignedTo(String assignedTo);
}
