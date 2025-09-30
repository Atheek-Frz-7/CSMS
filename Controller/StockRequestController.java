package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.StockRequest;
import com.csms.computer_store.Entity.SparePart;
import com.csms.computer_store.Service.StockRequestService;
import com.csms.computer_store.Service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-requests")
public class StockRequestController {
    @Autowired
    private StockRequestService stockRequestService;
    @Autowired
    private SparePartService sparePartService;

    // Create new stock request
    @PostMapping("/create")
    public ResponseEntity<StockRequest> createRequest(@RequestBody StockRequest request) {
        StockRequest savedRequest = stockRequestService.createRequest(request);
        return ResponseEntity.ok(savedRequest);
    }

    // Get all requests
    @GetMapping("/all")
    public ResponseEntity<List<StockRequest>> getAllRequests() {
        return ResponseEntity.ok(stockRequestService.getAllRequests());
    }

    // Get requests by part code
    @GetMapping("/part/{partCode}")
    public ResponseEntity<List<StockRequest>> getRequestsByPart(@PathVariable String partCode) {
        // Fetch the part from DB by code for correct mapping
        return ResponseEntity.ok(stockRequestService.getRequestsByPartByCode(partCode));
    }

    // Get requests by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<StockRequest>> getRequestsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(stockRequestService.getRequestsByStatus(status));
    }
}
