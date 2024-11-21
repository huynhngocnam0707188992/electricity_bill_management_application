package com.example.electricity_bill_management_app.entity;

import java.util.Date;

public class VNElectricBill extends ElectricBill {

    private VNCustomerType vnCustomerType;
    private int norm;

  

    public VNElectricBill(String billID, int quantity, float unitPrice, Date billDate, String customerName,
            VNCustomerType vnCustomerType, int norm) {
        super(billID, quantity, unitPrice, billDate, customerName);
        this.vnCustomerType = vnCustomerType;
        this.norm = norm;
    }

    public int getNorm() {
        return norm;
    }

    public void setNorm(int norm) {
        this.norm = norm;
    }

    public VNCustomerType getVnCustomerType() {
        return vnCustomerType;
    }

    public void setVnCustomerType(VNCustomerType vnCustomerType) {
        this.vnCustomerType = vnCustomerType;
    }

    public float calculated() {
        if (this.quantity <= this.norm) {
            this.totalPrice = this.quantity * this.unitPrice;
        } else {
            this.totalPrice = (float) (this.quantity * this.unitPrice * this.norm
                    + (this.norm - this.quantity) * this.unitPrice * 2.5);
        }
        return this.totalPrice;
    };
}
