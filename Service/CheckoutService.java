package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.Product;
import com.csms.computer_store.Entity.Receipt;
import com.csms.computer_store.Entity.Sale;
import com.csms.computer_store.Repository.ProductRepository;
import com.csms.computer_store.Repository.ReceiptRepository;
import com.csms.computer_store.Repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CheckoutService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ReceiptRepository receiptRepository;

    public CheckoutService(SaleRepository saleRepository,
                           ProductRepository productRepository,
                           ReceiptRepository receiptRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.receiptRepository = receiptRepository;
    }

    /**
     * Step 1–4: Staff requests order list & selects an order
     */
    public List<Sale> getAllCustomerOrders() {
        return saleRepository.findAll();
    }

    /**
     * Step 5–7: Confirm order → Generate receipt → Deduct inventory
     */
    public Receipt checkoutOrder(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Deduct purchased products from inventory (simple demo)
        // Assume each order is 1 quantity of product
        // (Extend later to actual order_items table if needed)
        // Example: productId = sale.getCustomerId() just for demo

        // Generate Receipt
        Receipt receipt = new Receipt();
        receipt.setReceiptNo("R-" + System.currentTimeMillis());
        receipt.setSale(sale);
        receipt.setCustomerId(sale.getCustomerId());
        receipt.setAmount(sale.getTotalAmount());
        receipt.setPaidDate(LocalDate.now());

        return receiptRepository.save(receipt);
    }
}
