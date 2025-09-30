package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.CustomerInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInvoiceRepository extends JpaRepository<CustomerInvoice, Long> {
    List<CustomerInvoice> findByCustomerCustomerId(Long customerId);
}
