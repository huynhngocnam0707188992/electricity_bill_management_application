package com.example.electricity_bill_management_app.database.billdatafind;

import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNElectricBill;
import com.example.electricity_bill_management_app.entity.VNCustomerType;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillDatabaseBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillOutputDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BillDAO implements SearchBillDatabaseBoundary {

    @Override
    public ElectricBill findBillByCustomerCode(String customerCode) {
        // Giả định bạn có kết nối tới cơ sở dữ liệu và thực hiện truy vấn
        // Đây là dữ liệu giả lập theo mã khách hàng
        if (customerCode.equals("C123")) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.OCTOBER, 15);
            Date billDate = calendar.getTime();

            // Trả về ví dụ hóa đơn cho khách hàng Việt Nam
            return new VNElectricBill("B001", 120, 3.5f, billDate, "Nguyen Van A", VNCustomerType.Residential, 100);
        } else if (customerCode.equals("F456")) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.SEPTEMBER, 10);
            Date billDate = calendar.getTime();

            // Trả về ví dụ hóa đơn cho khách hàng nước ngoài
            return new ForeignElectricBill("B002", 150, 4.0f, billDate, "John Doe", "USA");
        }

        // Không tìm thấy hóa đơn
        return null;
    }

    @Override
    public List<SearchBillOutputDTO> findBillsByMonthAndYear(int month, int year) {
        List<SearchBillOutputDTO> bills = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        // Giả lập dữ liệu hóa đơn cho tháng và năm nhất định
        if (month == 10 && year == 2024) {
            // Ví dụ hóa đơn cho khách hàng Việt Nam
            calendar.set(2024, Calendar.OCTOBER, 15);
            bills.add(new SearchBillOutputDTO(
                "B001", "Nguyen Van A", calendar.getTime(), 350.0f));

            // Ví dụ hóa đơn cho khách hàng nước ngoài
            calendar.set(2024, Calendar.OCTOBER, 20);
            bills.add(new SearchBillOutputDTO(
                "B002", "John Doe", calendar.getTime(), 600.0f));
        }

        return bills;
    }
}
