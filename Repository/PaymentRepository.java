package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByPaymentDate(LocalDate date);
    List<Payment> findByPaymentMethod(String paymentMethod);
}
