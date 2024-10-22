package com.example.electricity_bill_management_app.usecase.update_bill;

import java.util.Date;

public class UpdateBillUseCase implements UpdateBillInputBoundary {
    private final UpdateBillOutputBoundary outputBoundary;
    private final UpdateBillDatabaseBoundary databaseBoundary;

    public UpdateBillUseCase(UpdateBillOutputBoundary outputBoundary,
                           UpdateBillDatabaseBoundary databaseBoundary) {
        this.outputBoundary = outputBoundary;
        this.databaseBoundary = databaseBoundary;
    }

    @Override
    public void execute(UpdateBillRequestDTO request) {
        try {
            if (!validateRequest(request)) {
                outputBoundary.presentValidationError("Dữ liệu đầu vào không hợp lệ");
                return;
            }

            boolean exists = databaseBoundary.validateBillExists(request.getId());
            if (!exists) {
                outputBoundary.presentNotFoundError("Không tìm thấy hóa đơn");
                return;
            }

            UpdateBillRequestDTO currentBill = databaseBoundary.findBillById(request.getId());
            if (currentBill == null) {
                outputBoundary.presentNotFoundError("Không thể lấy thông tin hóa đơn");
                return;
            }

            request.setUpdatedAt(new Date());
            UpdateBillRequestDTO updatedBill = databaseBoundary.updateBill(request);
            outputBoundary.presentUpdateSuccess(updatedBill);

        } catch (Exception error) {
            outputBoundary.presentSystemError(new Error(error.getMessage()));
        }
    }

    private boolean validateRequest(UpdateBillRequestDTO request) {
        return request.getId() != null &&
               !request.getId().isEmpty() &&
               request.getCustomerName() != null &&
               !request.getCustomerName().isEmpty() &&
               request.getAmount() > 0 &&
               request.getItems() != null &&
               !request.getItems().isEmpty() &&
               request.getItems().stream()
                      .allMatch(item -> item.getQuantity() > 0 && 
                                      item.getUnitPrice() > 0 &&
                                      item.getProductName() != null &&
                                      !item.getProductName().isEmpty());
    }
}
