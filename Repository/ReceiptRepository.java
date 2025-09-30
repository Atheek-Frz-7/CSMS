package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    Receipt findByReceiptNo(String receiptNo);
}
