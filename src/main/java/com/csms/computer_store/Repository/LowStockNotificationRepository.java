package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.LowStockNotification;
import com.csms.computer_store.Entity.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LowStockNotificationRepository extends JpaRepository<LowStockNotification, Long> {

    // Find unresolved notifications
    List<LowStockNotification> findByResolvedFalse();

    // Find notifications by specific part
    List<LowStockNotification> findByPart(SparePart part);
}
