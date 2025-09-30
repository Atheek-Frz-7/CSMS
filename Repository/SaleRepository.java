package com.csms.computer_store.Repository;


import com.csms.computer_store.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findBySaleDate(LocalDate saleDate);
    List<Sale> findByStaff_UserId(Long userId);
}
