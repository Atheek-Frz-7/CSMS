package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.FinancePurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

// ----------------- FinancePurchaseRequest -----------------
public interface FinancePurchaseRequestRepository extends JpaRepository<FinancePurchaseRequest, Long> {}
