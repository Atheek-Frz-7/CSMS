package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.*;
import com.csms.computer_store.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final SalesStaffService salesStaffService;
    private final SalesManagerService salesManagerService;
    private final ITTechnicianService itTechnicianService;
    private final FinanceAccountantService financeAccountantService;
    private final SupplierService supplierService;

    public EmployeeController(SalesStaffService salesStaffService,
                              SalesManagerService salesManagerService,
                              ITTechnicianService itTechnicianService,
                              FinanceAccountantService financeAccountantService,
                              SupplierService supplierService) {
        this.salesStaffService = salesStaffService;
        this.salesManagerService = salesManagerService;
        this.itTechnicianService = itTechnicianService;
        this.financeAccountantService = financeAccountantService;
        this.supplierService = supplierService;
    }

    // ---------------- Sales Staff ----------------
    @GetMapping("/sales_staff")
    public List<SalesStaff> getAllSalesStaff() {
        return salesStaffService.getAllSalesStaff();
    }

    @PostMapping("/sales_staff")
    public ResponseEntity<SalesStaff> createSalesStaff(@RequestBody SalesStaff staff) {
        return ResponseEntity.ok(salesStaffService.createSalesStaff(staff));
    }

    // ---------------- Sales Manager ----------------
    @GetMapping("/sales_managers")
    public List<SalesManager> getAllSalesManagers() {
        return salesManagerService.getAllSalesManagers();
    }

    @PostMapping("/sales_managers")
    public ResponseEntity<SalesManager> createSalesManager(@RequestBody SalesManager manager) {
        return ResponseEntity.ok(salesManagerService.createSalesManager(manager));
    }

    // ---------------- IT Technician ----------------
    @GetMapping("/it_technicians")
    public List<ITTechnician> getAllITTechnicians() {
        return itTechnicianService.getAllITTechnicians();
    }

    @PostMapping("/it_technicians")
    public ResponseEntity<ITTechnician> createITTechnician(@RequestBody ITTechnician tech) {
        return ResponseEntity.ok(itTechnicianService.createITTechnician(tech));
    }

    // ---------------- Finance Accountant ----------------
    @GetMapping("/finance_accountants")
    public List<FinanceAccountant> getAllFinanceAccountants() {
        return financeAccountantService.getAllFinanceAccountants();
    }

    @PostMapping("/finance_accountants")
    public ResponseEntity<FinanceAccountant> createFinanceAccountant(@RequestBody FinanceAccountant accountant) {
        return ResponseEntity.ok(financeAccountantService.createFinanceAccountant(accountant));
    }

    // ---------------- Supplier ----------------
    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/suppliers")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.createSupplier(supplier));
    }
}
