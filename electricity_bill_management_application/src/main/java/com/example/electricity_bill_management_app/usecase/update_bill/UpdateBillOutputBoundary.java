package com.example.electricity_bill_management_app.usecase.update_bill;

public interface UpdateBillOutputBoundary {
    void presentUpdateSuccess(UpdateBillRequestDTO bill);
    void presentValidationError(String message);
    void presentNotFoundError(String message);
    void presentSystemError(Error error);
}
