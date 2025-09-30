package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.Product;
import com.csms.computer_store.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
    private final ProductRepository productRepository;
    private final Map<Long, Integer> cart = new HashMap<>(); // productId -> quantity

    @Autowired
    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 🔹 Add to cart
    public String addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Assuming Product has getStock() for available quantity
        if (product.getStock() < quantity) {
            return "Not Available";
        }
        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
        return "Added to cart";
    }

    // 🔹 View Cart
    public Map<Long, Integer> viewCart() {
        return cart;
    }

    // 🔹 Remove from cart
    public void removeFromCart(Long productId) {
        cart.remove(productId);
    }
}
