package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.Date;

public class SearchBillOutputDTO {
    private String billID; // Mã hóa đơn
    private String customerName; // Tên khách hàng
    private Date billDate; // Ngày ra hóa đơn
    private float totalPrice; // Thành tiền

    public SearchBillOutputDTO(String billID, String customerName, Date billDate, float totalPrice) {
        this.billID = billID;
        this.customerName = customerName;
        this.billDate = billDate;
        this.totalPrice = totalPrice;
    }

    // Getters
    public String getBillID() {
        return billID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getBillDate() {
        return billDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
