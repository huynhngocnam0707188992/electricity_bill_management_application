package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.List;
import java.util.Collections; // Thêm import này

import com.example.electricity_bill_management_app.entity.ElectricBill;

public class BillSearchUseCase implements BillSearchUseCaseInputBoundary {
    private final BillRepositoryBoundary<ElectricBill> repository;
    private final BillSearchUseCaseOutputBoundary outputBoundary;

    public BillSearchUseCase(BillRepositoryBoundary<ElectricBill> repository, BillSearchUseCaseOutputBoundary outputBoundary) {
        if (repository == null || outputBoundary == null) {
            throw new IllegalArgumentException("Repository và output boundary không được là null");
        }
        this.repository = repository;
        this.outputBoundary = outputBoundary; // Tiêm output boundary (trình bày)
    }

    @Override
    public void execute(BillSearchInputDTO inputDTO) {
        if (inputDTO == null || inputDTO.getCustomerCode() == null) {
            outputBoundary.present(new BillSearchOutputDTO(Collections.emptyList())); // Trình bày kết quả rỗng
            return;
        }

        // Tìm kiếm hóa đơn theo mã khách hàng
        List<ElectricBill> bills = repository.findBillByCustomerCode(inputDTO.getCustomerCode());

        // Tạo output DTO với kết quả tìm kiếm
        BillSearchOutputDTO outputDTO = new BillSearchOutputDTO(bills);

        // Trình bày kết quả bằng cách sử dụng output boundary
        outputBoundary.present(outputDTO);
    }
}
