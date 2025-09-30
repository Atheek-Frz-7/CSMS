package com.csms.computer_store.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("SALES_STAFF")  // For inheritance mapping
public class SalesStaff extends Employee {

    // Optional: Staff-specific fields
    @Column(name = "contact_no")
    private String contactNo;

    // Relationships
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<Sale> sales;

    // Constructors
    public SalesStaff() {}

    public SalesStaff(String userName, String email, String phone) {
        super(userName, email, phone, "SALES_STAFF");
    }

    public SalesStaff(String userName, String email, String phone, String contactNo) {
        super(userName, email, phone, "SALES_STAFF");
        this.contactNo = contactNo;
    }

    // Getters & Setters
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
