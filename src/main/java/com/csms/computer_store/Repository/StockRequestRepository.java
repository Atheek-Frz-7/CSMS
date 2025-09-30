package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.StockRequest;
import com.csms.computer_store.Entity.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRequestRepository extends JpaRepository<StockRequest, Long> {

    // Find all requests for a specific part
    List<StockRequest> findByPart(SparePart part);

    // Find requests by status (e.g., PENDING, SENT)
    List<StockRequest> findByStatus(String status);
}
