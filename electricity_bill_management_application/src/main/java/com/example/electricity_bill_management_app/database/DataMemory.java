package com.example.electricity_bill_management_app.database;

import java.util.HashMap;
import java.util.Map;

import com.example.electricity_bill_management_app.entity.ElectricBill;

public class DataMemory {
    private Map<Integer, ElectricBill> database = new HashMap<>();


    public Map<Integer, ElectricBill> getDatabase() {
        return database;
    }
    
}
