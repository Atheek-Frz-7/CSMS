package com.csms.computer_store.Entity;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FINANCE_ACCOUNTANT")
public class FinanceAccountant extends Employee {

    public FinanceAccountant() {}

    public FinanceAccountant(String userName, String email, String phone) {
        super(userName, email, phone, "FINANCE_ACCOUNTANT");
    }

    // You can add finance-specific fields or methods here
}
