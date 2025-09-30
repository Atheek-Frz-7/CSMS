package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.SalesManager;
import com.csms.computer_store.Repository.SalesManagerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesManagerService {
    private final SalesManagerRepository repository;
    public SalesManagerService(SalesManagerRepository repository) {
        this.repository = repository;
    }
    public List<SalesManager> getAllSalesManagers() {
        return repository.findAll();
    }
    public SalesManager createSalesManager(SalesManager manager) {
        return repository.save(manager);
    }
}

