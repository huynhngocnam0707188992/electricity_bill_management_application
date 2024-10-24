package com.example.electricity_bill_management_app.usecase.findcustomer;

import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;

public interface BillSearchDatabaseBoundary {

    List<ElectricBill> getBillList();

}
