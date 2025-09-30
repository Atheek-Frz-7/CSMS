package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.FinanceAccountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceAccountantRepository extends JpaRepository<FinanceAccountant, Long> {
}

