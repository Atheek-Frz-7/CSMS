package com.csms.computer_store.Repository;



import com.csms.computer_store.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Date;

// ----------------- FinanceDeliveryItem -----------------
public interface FinanceDeliveryItemRepository extends JpaRepository<FinanceDeliveryItem, Long> {}

