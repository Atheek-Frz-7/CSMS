package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.SystemLog;
import com.csms.computer_store.Repository.SystemLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemLogService {

    private final SystemLogRepository logRepo;

    public SystemLogService(SystemLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    public SystemLog createLog(SystemLog log) {
        return logRepo.save(log);
    }

    public Optional<SystemLog> getLogById(Long id) {
        return logRepo.findById(id);
    }

    public List<SystemLog> getAllLogs() {
        return logRepo.findAll();
    }

    public List<SystemLog> getLogsBySeverity(String severity) {
        return logRepo.findBySeverity(severity);
    }

    public List<SystemLog> getLogsByStatus(String status) {
        return logRepo.findByStatus(status);
    }

    public SystemLog updateLog(SystemLog log) {
        return logRepo.save(log);
    }

    public void deleteLog(Long id) {
        logRepo.deleteById(id);
    }
}
