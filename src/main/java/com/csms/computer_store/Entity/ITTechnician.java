package com.csms.computer_store.Entity;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("IT_TECHNICIAN")
public class ITTechnician extends Employee {

    public ITTechnician() {}

    public ITTechnician(String userName, String email, String phone) {
        super(userName, email, phone, "IT_TECHNICIAN");
    }

    // You can add IT-specific fields or methods here
}
