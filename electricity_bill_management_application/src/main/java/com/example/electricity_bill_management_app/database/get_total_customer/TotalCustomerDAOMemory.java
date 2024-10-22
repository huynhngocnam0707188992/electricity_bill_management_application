package com.example.electricity_bill_management_app.database.get_total_customer;

import java.util.Map;

import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNElectricBill;
import com.example.electricity_bill_management_app.usecase.get_total_customer.TotalCustomerDatabaseBoundary;

public class TotalCustomerDAOMemory implements TotalCustomerDatabaseBoundary{
   

    private Map<String, ElectricBill> database=null;


    public TotalCustomerDAOMemory(Map<String, ElectricBill> database) {
        this.database = database;
    }


    @Override
    public int getTotalCusByCategory(String customerCategory) {
        int customerQuantity = 0;
        
        for (ElectricBill bill : database.values()) {
            if (customerCategory.equals("VN") && bill instanceof VNElectricBill) {
                customerQuantity++;
            } else if (customerCategory.equals("Foreign") && bill instanceof ForeignElectricBill) {
                customerQuantity++;
            }
        }
        
        return customerQuantity;
    }
    
}
