package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.SparePart;
import com.csms.computer_store.Repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparePartService {

    @Autowired
    private SparePartRepository sparePartRepository;

    // Add new spare part
    public SparePart addSparePart(SparePart part) {
        if (sparePartRepository.existsByCode(part.getCode())) {
            throw new IllegalArgumentException("Part code already exists.");
        }
        return sparePartRepository.save(part);
    }

    // Update stock details
    public SparePart updateSparePart(SparePart part) {
        return sparePartRepository.save(part);
    }

    // Get all spare parts
    public List<SparePart> getAllParts() {
        return sparePartRepository.findAll();
    }

    // Find part by code
    public Optional<SparePart> getPartByCode(String code) {
        return sparePartRepository.findByCode(code);
    }
}
