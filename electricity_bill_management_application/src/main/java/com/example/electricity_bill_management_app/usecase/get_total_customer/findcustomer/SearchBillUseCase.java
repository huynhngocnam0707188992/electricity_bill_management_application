package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.ArrayList;
import java.util.List;
import com.example.electricity_bill_management_app.entity.ElectricBill;

public class SearchBillUseCase implements SearchBillInputBoundary {
    private SearchBillOutputBoundary outputBoundary;
    private SearchBillDatabaseBoundary billDatabase;

    public SearchBillUseCase(SearchBillOutputBoundary outputBoundary, SearchBillDatabaseBoundary billDatabase) {
        this.outputBoundary = outputBoundary;
        this.billDatabase = billDatabase;
    }

    @Override
    public void execute(String customerCode, int month, int year) {
        List<ElectricBill> foundBills = new ArrayList<>();

        if (customerCode != null && !customerCode.isEmpty()) {
            // Tìm theo mã khách hàng
            ElectricBill bill = billDatabase.findBillByCustomerCode(customerCode);
            if (bill != null) {
                foundBills.add(bill);
            }
        } else {
            // Tìm theo tháng và năm
            foundBills = billDatabase.findBillsByMonthAndYear(month, year);
        }

        // Chuyển đổi danh sách hóa đơn thành danh sách DTO
        List<SearchBillOutputDTO> outputDTOList = new ArrayList<>();
        for (ElectricBill bill : foundBills) {
            SearchBillOutputDTO dto = new SearchBillOutputDTO(
                bill.getBillID(),
                bill.getCustomerName(),
                bill.getBillDate(),
                bill.getTotalPrice() // Sử dụng phương thức tính tổng tiền
            );
            outputDTOList.add(dto);
        }

        // Xuất ra
        outputBoundary.present(outputDTOList);
    }
}
