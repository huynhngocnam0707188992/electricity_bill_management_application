package com.example.electricity_bill_management_app.database.DeleteBillDAOMemory;

import java.util.List;
import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillDatabaseBoundary;

public class DeleteBillDAOMemory implements DeleteBillDatabaseBoundary {

    private List<ElectricBill> database;

    // Constructor nhận List<ElectricBill>
    public DeleteBillDAOMemory(List<ElectricBill> database) {
        this.database = database;
    }

    @Override
    public List<ElectricBill> getBillList() {
        return database;
    }
}
