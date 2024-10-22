package com.example.electricity_bill_management_app.entity;

import java.util.Date;

public class ElectricBill {
    private String billID; // Mã hóa đơn
    private String customerCode; // Mã khách hàng
    private Date billDate; // Ngày ra hóa đơn
    private float totalPrice; // Thành tiền

    // Constructor với các tham số
    public ElectricBill(String billID, String customerCode, Date billDate, float totalPrice) {
        this.billID = billID;
        this.customerCode = customerCode;
        this.billDate = billDate;
        this.totalPrice = totalPrice;
    }

    // Getters và setters nếu cần
    public String getBillID() {
        return billID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public Date getBillDate() {
        return billDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
