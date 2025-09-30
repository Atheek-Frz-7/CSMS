package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.FinanceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// ----------------- FinanceOrder -----------------
public interface FinanceOrderRepository extends JpaRepository<FinanceOrder, Long> {
    List<FinanceOrder> findByOrderStatus(String orderStatus);
}
