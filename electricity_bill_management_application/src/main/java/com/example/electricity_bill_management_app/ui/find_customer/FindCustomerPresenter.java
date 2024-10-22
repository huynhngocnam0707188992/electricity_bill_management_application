package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillOutputBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillOutputDTO;

import java.util.List;

public class FindCustomerPresenter implements SearchBillOutputBoundary {
    private FindCustomerForm findCustomerForm;

    // Constructor nhận vào FindCustomerForm để cập nhật kết quả lên giao diện
    public FindCustomerPresenter(FindCustomerForm findCustomerForm) {
        this.findCustomerForm = findCustomerForm;
    }

    // Override phương thức present theo đúng định nghĩa trong SearchBillOutputBoundary
    @Override
    public void present(List<SearchBillOutputDTO> listOutputDTO) {
        // Hiển thị kết quả trên giao diện thông qua FindCustomerForm
        findCustomerForm.displayResults(listOutputDTO);
    }
}
