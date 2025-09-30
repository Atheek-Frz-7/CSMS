package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.StockRequest;
import com.csms.computer_store.Entity.SparePart;
import com.csms.computer_store.Repository.StockRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRequestService {

    @Autowired
    private StockRequestRepository stockRequestRepository;

    @Autowired
    private com.csms.computer_store.Repository.SparePartRepository sparePartRepository;

    // Create new stock request
    public StockRequest createRequest(StockRequest request) {
        return stockRequestRepository.save(request);
    }

    // Get all requests
    public List<StockRequest> getAllRequests() {
        return stockRequestRepository.findAll();
    }

    // Get requests by part
    public List<StockRequest> getRequestsByPart(SparePart part) {
        return stockRequestRepository.findByPart(part);
    }

    // Get requests by status
    public List<StockRequest> getRequestsByStatus(String status) {
        return stockRequestRepository.findByStatus(status);
    }

    public List<StockRequest> getRequestsByPartByCode(String partCode) {
        return sparePartRepository.findByCode(partCode)
                .map(stockRequestRepository::findByPart)
                .orElse(List.of());
    }
}
