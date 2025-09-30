package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.LowStockNotification;
import com.csms.computer_store.Entity.SparePart;
import com.csms.computer_store.Service.LowStockNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/low-stock")
public class LowStockNotificationController {

    @Autowired
    private LowStockNotificationService notificationService;

    // Create new low stock notification
    @PostMapping("/create")
    public ResponseEntity<LowStockNotification> createNotification(@RequestBody LowStockNotification notification) {
        return ResponseEntity.ok(notificationService.createNotification(notification));
    }

    // Get unresolved notifications
    @GetMapping("/unresolved")
    public ResponseEntity<List<LowStockNotification>> getUnresolvedNotifications() {
        return ResponseEntity.ok(notificationService.getUnresolvedNotifications());
    }

    // Get notifications by part code
    @GetMapping("/part/{partCode}")
    public ResponseEntity<List<LowStockNotification>> getNotificationsByPart(@PathVariable String partCode) {
        // Fetch the part from DB by code for correct mapping
        return ResponseEntity.ok(notificationService.getNotificationsByPartByCode(partCode));
    }

    // Resolve notification
    @PutMapping("/resolve")
    public ResponseEntity<LowStockNotification> resolveNotification(@RequestBody LowStockNotification notification) {
        return ResponseEntity.ok(notificationService.resolveNotification(notification));
    }
}
