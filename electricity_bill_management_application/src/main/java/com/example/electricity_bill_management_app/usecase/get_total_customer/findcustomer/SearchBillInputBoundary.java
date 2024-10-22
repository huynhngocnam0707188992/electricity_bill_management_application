package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

public interface SearchBillInputBoundary {
    void execute(String customerCode, int month, int year);
}
