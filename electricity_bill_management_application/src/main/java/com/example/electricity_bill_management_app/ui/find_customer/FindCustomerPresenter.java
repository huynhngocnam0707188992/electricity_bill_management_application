package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.usecase.FindCustomerOutputBoundary;
import com.example.electricity_bill_management_app.usecase.SearchBillOutputDTO;

import java.util.List;

public class FindCustomerPresenter implements FindCustomerOutputBoundary {
    private FindCustomerForm findCustomerForm;

    public FindCustomerPresenter(FindCustomerForm findCustomerForm) {
        this.findCustomerForm = findCustomerForm;
    }

    @Override
    public void present(List<SearchBillOutputDTO> bills) {
        // Hiển thị kết quả trên giao diện
        findCustomerForm.displayResults(bills);
    }
}
