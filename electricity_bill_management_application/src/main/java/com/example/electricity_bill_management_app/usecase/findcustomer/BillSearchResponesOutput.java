package com.example.electricity_bill_management_app.usecase.findcustomer;

import java.util.Date;

import com.example.electricity_bill_management_app.entity.VNCustomerType;


public class BillSearchResponesOutput {
    protected String Name;
    protected String Bill;
    protected int Quantity;
    protected Date BillDate;
    protected float UnitPrice;

    protected VNCustomerType vnCustomerType;
    protected int norm;
    protected String nationality;

    public BillSearchResponesOutput(String name, String bill, int quantity, Date billDate, float unitPrice) {
        Name = name;
        Bill = bill;
        Quantity = quantity;
        BillDate = billDate;
        UnitPrice = unitPrice;
    }

    


    public BillSearchResponesOutput(String name, String bill, int quantity, Date billDate, float unitPrice,
            String nationality) {
       this(name, bill, quantity, billDate, unitPrice);
        this.nationality = nationality;
    }




    public VNCustomerType getVnCustomerType() {
        return vnCustomerType;
    }




    public void setVnCustomerType(VNCustomerType vnCustomerType) {
        this.vnCustomerType = vnCustomerType;
    }




    public int getNorm() {
        return norm;
    }




    public void setNorm(int norm) {
        this.norm = norm;
    }




    public String getNationality() {
        return nationality;
    }




    public void setNationality(String nationality) {
        this.nationality = nationality;
    }




    public BillSearchResponesOutput(String name, String bill, int quantity, Date billDate, float unitPrice,
            VNCustomerType vnCustomerType, int norm) {
        this(name, bill, quantity, billDate, unitPrice);
        this.vnCustomerType = vnCustomerType;
        this.norm = norm;
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




    public Object getCustomerCode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerCode'");
    }

    
    
}
