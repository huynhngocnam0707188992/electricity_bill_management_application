package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.List;

public class ResponseBillList {
    private List<SearchBillOutputDTO> bills; // Danh sách DTO hóa đơn
    private String message = "GET_BILL_LIST_OK"; // Thông điệp phản hồi

    public ResponseBillList(List<SearchBillOutputDTO> bills) {
        this.bills = bills; // Khởi tạo danh sách hóa đơn
    }

    public List<SearchBillOutputDTO> getBills() {
        return bills; // Trả về danh sách hóa đơn
    }

    public String getMessage() {
        return message; // Trả về thông điệp phản hồi
    }
}

