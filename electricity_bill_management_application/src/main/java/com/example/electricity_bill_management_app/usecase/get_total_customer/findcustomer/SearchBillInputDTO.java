package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.Date;

public class SearchBillInputDTO {

    protected String customerCode; // Mã khách hàng
    protected Date billDate;       // Ngày hóa đơn
    private int month;             // Tháng tìm kiếm
    private int year;              // Năm tìm kiếm

    // Constructor riêng chỉ cho việc tìm kiếm theo mã khách hàng
    private SearchBillInputDTO(String customerCode) {
        this.customerCode = customerCode;
    }

    // Constructor tìm kiếm theo mã khách hàng và ngày hóa đơn
    public SearchBillInputDTO(String customerCode, Date billDate) {
        this(customerCode);
        this.billDate = billDate;
    }

    // Constructor tìm kiếm theo tháng và năm
    public SearchBillInputDTO(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public Date getBillDate() {
        return billDate;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
