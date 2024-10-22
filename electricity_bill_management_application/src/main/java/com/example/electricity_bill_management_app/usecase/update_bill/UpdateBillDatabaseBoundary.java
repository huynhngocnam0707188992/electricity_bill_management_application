package com.example.electricity_bill_management_app.usecase.update_bill;

public interface UpdateBillDatabaseBoundary {
    UpdateBillRequestDTO findBillById(String id);
    boolean validateBillExists(String id);
    UpdateBillRequestDTO updateBill(UpdateBillRequestDTO bill);
}
