package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.FinanceInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// ----------------- FinanceInvoice -----------------
public interface FinanceInvoiceRepository extends JpaRepository<FinanceInvoice, Long> {
    List<FinanceInvoice> findByInvoiceType(String type); // SALES or PURCHASE
}
