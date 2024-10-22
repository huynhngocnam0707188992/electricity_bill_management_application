package com.example.electricity_bill_management_app.database;

import java.util.HashMap;
import java.util.Map;

import com.example.electricity_bill_management_app.entity.ElectricBill;

public class DataMemory {
    private Map<String, ElectricBill> database = new HashMap<>();


    public Map<String, ElectricBill> getDatabase() {
        return database;
    }
    
}
