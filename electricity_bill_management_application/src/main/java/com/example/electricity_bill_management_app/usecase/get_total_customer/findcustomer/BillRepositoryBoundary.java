package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;
import java.util.List;

public interface BillRepositoryBoundary<ElectricBill> {
    List<ElectricBill> findBillByCustomerCode(String customerCode);
}
