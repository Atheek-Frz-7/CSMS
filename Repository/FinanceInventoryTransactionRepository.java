package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.FinanceInventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

// ----------------- FinanceInventoryTransaction -----------------
public interface FinanceInventoryTransactionRepository extends JpaRepository<FinanceInventoryTransaction, Long> {}
