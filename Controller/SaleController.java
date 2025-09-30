package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.Sale;
import com.csms.computer_store.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    // Get all sales
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    // Get sale by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    // Create a new sale
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return ResponseEntity.ok(saleService.createSale(sale));
    }

    // Update a sale
    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long id, @RequestBody Sale saleDetails) {
        return ResponseEntity.ok(saleService.updateSale(id, saleDetails));
    }

    // Delete a sale
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
