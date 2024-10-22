package com.example.electricity_bill_management_app.entity;

import java.util.Date;

import com.example.electricity_bill_management_app.usecase.get_total_customer.DTO.TotalCustomerInputDTO;
public abstract class ElectricBill {

    protected String billID;
    protected int quantity;
    protected float unitPrice;
    protected float totalPrice;
    protected Date billDate;
    protected String customerName;
    
    public ElectricBill() {
    }
    public ElectricBill(String billID, int quantity, float unitPrice, Date billDate,
            String customerName) {
        this.billID = billID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.billDate = billDate;
        this.customerName = customerName;
    }

    protected void execute (TotalCustomerInputDTO totalCustomerInputDTO){

    }



    public String getBillID() {
        return billID;
    }
    public void setBillID(String billID) {
        this.billID = billID;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
   
    public Date getBillDate() {
        return billDate;
    }
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    

}
