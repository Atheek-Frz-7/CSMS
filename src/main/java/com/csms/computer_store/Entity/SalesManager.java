package com.csms.computer_store.Entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SALES_MANAGER")
public class SalesManager extends Employee {

    public SalesManager() {}

    public SalesManager(String userName, String email, String phone) {
        super(userName, email, phone, "SALES_MANAGER");
    }

    // Sales manager-specific fields/methods
}
