package com.example.electricity_bill_management_app.entity;

import java.util.Date;

public abstract class ElectricBill {
    protected String billID; // Mã hóa đơn
    protected int quantity; // Số lượng KW tiêu thụ
    protected float unitPrice; // Đơn giá
    protected int norm; // Định mức
    protected float totalPrice; // Thành tiền
    protected Date billDate; // Ngày ra hóa đơn
    protected String customerName; // Tên khách hàng

    public ElectricBill() {
    }

    public ElectricBill(String billID, int quantity, float unitPrice, int norm, Date billDate, String customerName) {
        this.billID = billID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.norm = norm;
        this.billDate = billDate;
        this.customerName = customerName;
        calculateTotalPrice(); // Tính toán thành tiền khi khởi tạo
    }

    public void calculateTotalPrice() {
        if (quantity <= norm) {
            totalPrice = quantity * unitPrice;
        } else {
            totalPrice = (norm * unitPrice) + ((quantity - norm) * unitPrice * 2.5f);
        }
    }

    // Getters và Setters
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
        calculateTotalPrice(); // Tính lại thành tiền khi thay đổi số lượng
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
        calculateTotalPrice(); // Tính lại thành tiền khi thay đổi đơn giá
    }

    public int getNorm() {
        return norm;
    }

    public void setNorm(int norm) {
        this.norm = norm;
        calculateTotalPrice(); // Tính lại thành tiền khi thay đổi định mức
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

    public float getTotalPrice() {
        return totalPrice;
    }
}
