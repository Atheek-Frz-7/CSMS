package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.SparePart;
import com.csms.computer_store.Service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class SparePartController {

    @Autowired
    private SparePartService sparePartService;

    // Add a new spare part
    @PostMapping("/add")
    public ResponseEntity<SparePart> addPart(@RequestBody SparePart part) {
        SparePart savedPart = sparePartService.addSparePart(part);
        return ResponseEntity.ok(savedPart);
    }

    // Update an existing part
    @PutMapping("/update")
    public ResponseEntity<SparePart> updatePart(@RequestBody SparePart part) {
        SparePart updatedPart = sparePartService.updateSparePart(part);
        return ResponseEntity.ok(updatedPart);
    }

    // Get all spare parts
    @GetMapping("/all")
    public ResponseEntity<List<SparePart>> getAllParts() {
        return ResponseEntity.ok(sparePartService.getAllParts());
    }

    // Get part by code
    @GetMapping("/{code}")
    public ResponseEntity<SparePart> getPartByCode(@PathVariable String code) {
        return sparePartService.getPartByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
