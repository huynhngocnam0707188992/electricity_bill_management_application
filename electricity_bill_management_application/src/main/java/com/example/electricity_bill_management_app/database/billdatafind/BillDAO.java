package com.example.electricity_bill_management_app.database.billdatafind;

import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillDatabaseBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillOutputDTO;

import java.util.ArrayList;

import java.util.List;
import java.util.Calendar;

public class BillDAO implements SearchBillDatabaseBoundary { // Đảm bảo implements đúng interface

    @Override
    public ElectricBill findBillByCustomerCode(String customerCode) {
        // Giả định bạn có kết nối tới cơ sở dữ liệu và thực hiện truy vấn
        // Dữ liệu giả lập
        if (customerCode.equals("C123")) {
            return new ElectricBill("B001", customerCode, Calendar.getInstance().getTime(), 100.50f);
        }
        return null; // Không tìm thấy hóa đơn
    }

    @Override
    public List<SearchBillOutputDTO> findBillsByMonthAndYear(int month, int year) {
        List<SearchBillOutputDTO> bills = new ArrayList<>();

        // Giả lập dữ liệu hóa đơn
        if (month == 10 && year == 2024) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, 15); // Ngày hóa đơn, giả định vào ngày 15

            bills.add(new SearchBillOutputDTO("B001", "C123", calendar.getTime(), 100.50f));
            bills.add(new SearchBillOutputDTO("B002", "C123", calendar.getTime(), 150.75f));
        }
        return bills; // Trả về danh sách hóa đơn
    }
}
