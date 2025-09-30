package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.CustomerReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerReceiptRepository extends JpaRepository<CustomerReceipt, Long> {
    List<CustomerReceipt> findByCustomerCustomerId(Long customerId);
    CustomerReceipt findByReceiptNo(String receiptNo);
}
