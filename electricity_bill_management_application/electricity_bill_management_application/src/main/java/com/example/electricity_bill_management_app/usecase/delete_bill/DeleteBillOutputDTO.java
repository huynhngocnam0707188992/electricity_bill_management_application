package com.example.electricity_bill_management_app.usecase.delete_bill;

import java.util.Date;

public class DeleteBillOutputDTO {
    protected String Name;
    protected String Bill;
    protected int Quantity;
    protected Date BillDate;
    protected float UnitPrice;
    public DeleteBillOutputDTO(String name, String bill, int quantity, Date billDate, float unitPrice) {
        Name = name;
        Bill = bill;
        Quantity = quantity;
        BillDate = billDate;
        UnitPrice = unitPrice;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getBill() {
        return Bill;
    }
    public void setBill(String bill) {
        Bill = bill;
    }
    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    public Date getBillDate() {
        return BillDate;
    }
    public void setBillDate(Date billDate) {
        BillDate = billDate;
    }
    public float getUnitPrice() {
        return UnitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        UnitPrice = unitPrice;
    }
    

    
    
    
}
