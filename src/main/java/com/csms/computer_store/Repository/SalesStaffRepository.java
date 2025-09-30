package com.csms.computer_store.Repository;


import com.csms.computer_store.Entity.SalesStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesStaffRepository extends JpaRepository<SalesStaff, Long> {
}
