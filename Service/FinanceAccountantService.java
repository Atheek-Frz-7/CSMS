package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.FinanceAccountant;
import com.csms.computer_store.Repository.FinanceAccountantRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FinanceAccountantService {
    private final FinanceAccountantRepository repository;
    public FinanceAccountantService(FinanceAccountantRepository repository) {
        this.repository = repository;
    }
    public List<FinanceAccountant> getAllFinanceAccountants() {
        return repository.findAll();
    }
    public FinanceAccountant createFinanceAccountant(FinanceAccountant accountant) {
        return repository.save(accountant);
    }
}

