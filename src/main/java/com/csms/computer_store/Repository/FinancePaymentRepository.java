package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.FinancePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancePaymentRepository extends JpaRepository<FinancePayment, Long> {

    // Find payments by order's ID (nested property)
    List<FinancePayment> findByOrder_OrderId(Long orderId);

    // Find payments by paymentStatus
    List<FinancePayment> findByPaymentStatus(String paymentStatus);
}
