package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.usecase.FindCustomerInputBoundary;

public class FindCustomerController {
    private FindCustomerInputBoundary findCustomerInputBoundary;

    public FindCustomerController(FindCustomerInputBoundary findCustomerInputBoundary) {
        this.findCustomerInputBoundary = findCustomerInputBoundary;
    }

    public void searchBill(String billID) {
        // Gọi use case để tìm kiếm hóa đơn
        findCustomerInputBoundary.execute(billID);
    }
}
