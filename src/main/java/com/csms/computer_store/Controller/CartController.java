package com.csms.computer_store.Controller;

import com.csms.computer_store.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add product to cart
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        String result = cartService.addToCart(productId, quantity);
        return ResponseEntity.ok(result);
    }

    // View cart contents
    @GetMapping("/view")
    public ResponseEntity<Map<Long, Integer>> viewCart() {
        return ResponseEntity.ok(cartService.viewCart());
    }

    // Remove product from cart
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long productId) {
        cartService.removeFromCart(productId);
        return ResponseEntity.noContent().build();
    }
}