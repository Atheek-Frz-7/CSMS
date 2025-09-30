package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.SystemLog;
import com.csms.computer_store.Service.SystemLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/it/logs")
public class SystemLogController {

    private final SystemLogService logService;

    public SystemLogController(SystemLogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public SystemLog createLog(@RequestBody SystemLog log) {
        return logService.createLog(log);
    }

    @GetMapping("/{id}")
    public Optional<SystemLog> getLogById(@PathVariable Long id) {
        return logService.getLogById(id);
    }

    @GetMapping
    public List<SystemLog> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/severity/{severity}")
    public List<SystemLog> getLogsBySeverity(@PathVariable String severity) {
        return logService.getLogsBySeverity(severity);
    }

    @GetMapping("/status/{status}")
    public List<SystemLog> getLogsByStatus(@PathVariable String status) {
        return logService.getLogsByStatus(status);
    }

    @PutMapping("/{id}")
    public SystemLog updateLog(@PathVariable Long id, @RequestBody SystemLog log) {
        log.setLogId(id);
        return logService.updateLog(log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);
    }
}
