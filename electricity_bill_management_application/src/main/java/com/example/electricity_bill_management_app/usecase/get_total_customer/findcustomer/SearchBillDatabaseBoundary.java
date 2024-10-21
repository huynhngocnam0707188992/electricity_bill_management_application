package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import com.example.electricity_bill_management_app.entity.ElectricBill;
import java.util.List;

public interface SearchBillDatabaseBoundary {
    ElectricBill findBillByCustomerCode(String customerCode);
    List<ElectricBill> findBillsByMonthAndYear(int month, int year);
}
