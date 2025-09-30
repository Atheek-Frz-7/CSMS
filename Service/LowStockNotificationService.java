package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.LowStockNotification;
import com.csms.computer_store.Entity.SparePart;
import com.csms.computer_store.Repository.LowStockNotificationRepository;
import com.csms.computer_store.Repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LowStockNotificationService {

    @Autowired
    private LowStockNotificationRepository notificationRepository;

    @Autowired
    private SparePartRepository sparePartRepository;

    // Save a new low stock notification
    public LowStockNotification createNotification(LowStockNotification notification) {
        return notificationRepository.save(notification);
    }

    // Get unresolved notifications
    public List<LowStockNotification> getUnresolvedNotifications() {
        return notificationRepository.findByResolvedFalse();
    }

    // Get notifications for a specific part
    public List<LowStockNotification> getNotificationsByPart(SparePart part) {
        return notificationRepository.findByPart(part);
    }

    // Mark notification as resolved
    public LowStockNotification resolveNotification(LowStockNotification notification) {
        notification.setResolved(true);
        return notificationRepository.save(notification);
    }

    public List<LowStockNotification> getNotificationsByPartByCode(String partCode) {
        // Use SparePartRepository to fetch the part by code
        return sparePartRepository.findByCode(partCode)
                .map(notificationRepository::findByPart)
                .orElse(List.of());
    }
}
