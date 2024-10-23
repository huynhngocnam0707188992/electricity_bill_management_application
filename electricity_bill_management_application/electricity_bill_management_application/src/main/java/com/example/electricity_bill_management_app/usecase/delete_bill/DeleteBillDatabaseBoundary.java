package com.example.electricity_bill_management_app.usecase.delete_bill;

import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;

public interface DeleteBillDatabaseBoundary {

    List<ElectricBill> getBillList();

}
