package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;

public class BillSearchOutputDTO {
    private List<ElectricBill> bills;

    public BillSearchOutputDTO(List<ElectricBill> bills) {
        this.bills = bills;
    }

    public List<ElectricBill> getBills() {
        return bills;
    }
}
