package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.Product;
import com.csms.computer_store.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductSearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 🔹 Search by keyword
    public List<Product> searchByName(String keyword) {
        // If ProductRepository does not have findByProductNameContainingIgnoreCase, filter manually
        return productRepository.findAll().stream()
            .filter(p -> p.getProductName() != null && p.getProductName().toLowerCase().contains(keyword.toLowerCase()))
            .toList();
    }

    // 🔹 Get all parts
    public List<Product> getAllParts() {
        return productRepository.findAll();
    }
}
