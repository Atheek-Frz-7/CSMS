package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.ITTechnician;
import com.csms.computer_store.Repository.ITTechnicianRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ITTechnicianService {
    private final ITTechnicianRepository repository;
    public ITTechnicianService(ITTechnicianRepository repository) {
        this.repository = repository;
    }
    public List<ITTechnician> getAllITTechnicians() {
        return repository.findAll();
    }
    public ITTechnician createITTechnician(ITTechnician tech) {
        return repository.save(tech);
    }
}

