package com.csms.computer_store.Repository;



import com.csms.computer_store.Entity.PurchaseRequest;
import com.csms.computer_store.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {

    // Find all requests by Supplier
    List<PurchaseRequest> findBySupplier(Supplier supplier);

    // Find by Supplier and Status (Pending, Accepted, Rejected, Received)
    List<PurchaseRequest> findBySupplierAndStatus(Supplier supplier, String status);
}
