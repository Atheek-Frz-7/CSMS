package com.csms.computer_store.Service;


import com.csms.computer_store.Entity.Supplier;
import com.csms.computer_store.Entity.PurchaseRequest;
import com.csms.computer_store.Entity.Delivery;
import com.csms.computer_store.Entity.SupplierPayment;
import com.csms.computer_store.Repository.SupplierRepository;
import com.csms.computer_store.Repository.PurchaseRequestRepository;
import com.csms.computer_store.Repository.DeliveryRepository;
import com.csms.computer_store.Repository.SupplierPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final PurchaseRequestRepository purchaseRequestRepository;
    private final DeliveryRepository deliveryRepository;
    private final SupplierPaymentRepository supplierPaymentRepository;

    public SupplierService(SupplierRepository supplierRepository,
                           PurchaseRequestRepository purchaseRequestRepository,
                           DeliveryRepository deliveryRepository,
                           SupplierPaymentRepository supplierPaymentRepository) {
        this.supplierRepository = supplierRepository;
        this.purchaseRequestRepository = purchaseRequestRepository;
        this.deliveryRepository = deliveryRepository;
        this.supplierPaymentRepository = supplierPaymentRepository;
    }

    // ----------------------------
    // CRUD for Supplier
    // ----------------------------
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier supplier = getSupplierById(id);
        supplier.setUserName(updatedSupplier.getUserName());
        supplier.setEmail(updatedSupplier.getEmail());
        supplier.setPhone(updatedSupplier.getPhone());
        supplier.setAddress(updatedSupplier.getAddress());
        supplier.setPasswordHash(updatedSupplier.getPasswordHash());
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    // ----------------------------
    // CRUD for PurchaseRequest
    // ----------------------------
    public PurchaseRequest createPurchaseRequest(PurchaseRequest request) {
        return purchaseRequestRepository.save(request);
    }

    public List<PurchaseRequest> getRequestsBySupplier(Long supplierId) {
        Supplier supplier = getSupplierById(supplierId);
        return purchaseRequestRepository.findBySupplier(supplier);
    }

    public PurchaseRequest updatePurchaseRequestStatus(Long requestId, String status) {
        PurchaseRequest request = purchaseRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(status);
        return purchaseRequestRepository.save(request);
    }

    public void deletePurchaseRequest(Long requestId) {
        purchaseRequestRepository.deleteById(requestId);
    }

    // ----------------------------
    // CRUD for Delivery
    // ----------------------------
    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getDeliveriesBySupplier(Long supplierId) {
        Supplier supplier = getSupplierById(supplierId);
        return deliveryRepository.findBySupplier(supplier);
    }

    public Delivery updateDelivery(Long deliveryId, Delivery updatedDelivery) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));

        delivery.setDeliveryDate(updatedDelivery.getDeliveryDate());
        delivery.setDeliveryTime(updatedDelivery.getDeliveryTime());
        delivery.setAddress(updatedDelivery.getAddress());
        delivery.setCost(updatedDelivery.getCost());
        delivery.setStatus(updatedDelivery.getStatus());

        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }

    // ----------------------------
    // CRUD for SupplierPayment
    // ----------------------------
    public SupplierPayment createPayment(SupplierPayment payment) {
        return supplierPaymentRepository.save(payment);
    }

    public List<SupplierPayment> getPaymentsBySupplier(Long supplierId) {
        Supplier supplier = getSupplierById(supplierId);
        return supplierPaymentRepository.findBySupplier(supplier);
    }

    public SupplierPayment updatePaymentStatus(Long paymentId, String status) {
        SupplierPayment payment = supplierPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setStatus(status);
        return supplierPaymentRepository.save(payment);
    }

    public void deletePayment(Long paymentId) {
        supplierPaymentRepository.deleteById(paymentId);
    }

    // ----------------------------
    // Business Scenarios
    // ----------------------------

    // ✅ 1. Receive Purchase Requests
    public List<PurchaseRequest> receivePurchaseRequests(Long supplierId) {
        Supplier supplier = getSupplierById(supplierId);
        return purchaseRequestRepository.findBySupplierAndStatus(supplier, "Pending");
    }

    // ✅ 2. Manage Delivery
    public Delivery manageDelivery(Long deliveryId, Delivery updatedDelivery) {
        return updateDelivery(deliveryId, updatedDelivery);
    }

    // ✅ 3. Access Past Payments
    public List<SupplierPayment> getPastPayments(Long supplierId) {
        return getPaymentsBySupplier(supplierId);
    }
}
