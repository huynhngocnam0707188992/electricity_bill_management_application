package com.example.electricity_bill_management_app.ui.get_update_bill;

import com.example.electricity_bill_management_app.usecase.update_bill.UpdateBillOutputBoundary;
import com.example.electricity_bill_management_app.usecase.update_bill.UpdateBillRequestDTO;

public class UpdateBillPresenter implements UpdateBillOutputBoundary {
    @Override
    public void presentUpdateSuccess(UpdateBillRequestDTO bill) {
        System.out.println("Cập nhật hóa đơn thành công: " + bill.getId());
    }

    @Override
    public void presentValidationError(String message) {
        System.out.println("Lỗi validation: " + message);
    }

    @Override
    public void presentNotFoundError(String message) {
        System.out.println("Lỗi không tìm thấy: " + message);
    }

    @Override
    public void presentSystemError(Error error) {
        System.out.println("Lỗi hệ thống: " + error.getMessage());
    }
}

