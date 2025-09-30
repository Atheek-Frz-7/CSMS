package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.SalesManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesManagerRepository extends JpaRepository<SalesManager, Long> {
}

