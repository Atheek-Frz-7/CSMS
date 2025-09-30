package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.SalesStaff;
import com.csms.computer_store.Repository.SalesStaffRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesStaffService {
    private final SalesStaffRepository repository;
    public SalesStaffService(SalesStaffRepository repository) {
        this.repository = repository;
    }
    public List<SalesStaff> getAllSalesStaff() {
        return repository.findAll();
    }
    public SalesStaff createSalesStaff(SalesStaff staff) {
        return repository.save(staff);
    }
}

