package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillInputBoundary;

public class FindCustomerController {
    private SearchBillInputBoundary searchBillInputBoundary;

    // Constructor nhận vào SearchBillInputBoundary thay cho FindCustomerInputBoundary
    public FindCustomerController(SearchBillInputBoundary searchBillInputBoundary) {
        this.searchBillInputBoundary = searchBillInputBoundary;
    }

    // Phương thức searchBill với ba tham số: customerCode, month và year
    public void searchBill(String customerCode, int month, int year) {
        // Gọi use case để tìm kiếm hóa đơn
        searchBillInputBoundary.execute(customerCode, month, year);
    }
}
