package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.Receipt;
import com.csms.computer_store.Entity.Sale;
import com.csms.computer_store.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    // List all customer orders
    @GetMapping("/orders")
    public ResponseEntity<List<Sale>> getAllCustomerOrders() {
        return ResponseEntity.ok(checkoutService.getAllCustomerOrders());
    }

    // Checkout an order and generate a receipt
    @PostMapping("/checkout/{saleId}")
    public ResponseEntity<Receipt> checkoutOrder(@PathVariable Long saleId) {
        Receipt receipt = checkoutService.checkoutOrder(saleId);
        return ResponseEntity.ok(receipt);
    }
}
