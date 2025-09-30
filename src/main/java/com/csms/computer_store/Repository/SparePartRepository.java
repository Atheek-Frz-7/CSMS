package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SparePartRepository extends JpaRepository<SparePart, Long> {

    // Find by unique code
    Optional<SparePart> findByCode(String code);

    // Check if a code exists
    boolean existsByCode(String code);
}
