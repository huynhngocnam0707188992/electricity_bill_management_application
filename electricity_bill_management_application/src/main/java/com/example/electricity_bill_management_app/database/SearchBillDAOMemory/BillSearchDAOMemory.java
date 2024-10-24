package com.example.electricity_bill_management_app.database.SearchBillDAOMemory;

import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchDatabaseBoundary;


public class BillSearchDAOMemory implements BillSearchDatabaseBoundary{
    private List<ElectricBill> database;

    // Constructor nhận List<ElectricBill>
    public BillSearchDAOMemory(List<ElectricBill> database) {
        this.database = database;
    }

    @Override
    public List<ElectricBill> getBillList() {
        return database;
    }
}
