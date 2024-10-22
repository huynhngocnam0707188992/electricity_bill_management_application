package com.example.electricity_bill_management_app.database;

import java.util.HashMap;
import java.util.Map;

import com.example.electricity_bill_management_app.usecase.update_bill.UpdateBillDatabaseBoundary;
import com.example.electricity_bill_management_app.usecase.update_bill.UpdateBillRequestDTO;

public class UpdateBillDAOMemory implements UpdateBillDatabaseBoundary {
    private final Map<String, UpdateBillRequestDTO> billMap;
    
    /**
     * Constructor to initialize the DAO with initial data
     * @param initialData Map containing initial bill data
     */
    public UpdateBillDAOMemory(Map<String, UpdateBillRequestDTO> initialData) {
        this.billMap = new HashMap<>(initialData);
    }

    /**
     * Default constructor that initializes an empty bill map
     */
    public UpdateBillDAOMemory() {
        this.billMap = new HashMap<>();
    }
    
    /**
     * Find a bill by its ID
     * @param id The bill ID to search for
     * @return The bill if found, null otherwise
     */
    @Override
    public UpdateBillRequestDTO findBillById(String id) {
        return billMap.get(id);
    }
    
    /**
     * Validate if a bill exists with the given ID
     * @param id The bill ID to validate
     * @return true if the bill exists, false otherwise
     */
    @Override
    public boolean validateBillExists(String id) {
        return billMap.containsKey(id);
    }
    
    /**
     * Update an existing bill
     * @param bill The bill data to update
     * @return The updated bill if successful, null if bill doesn't exist
     */
    @Override
    public UpdateBillRequestDTO updateBill(UpdateBillRequestDTO bill) {
        if (billMap.containsKey(bill.getId())) {
            billMap.put(bill.getId(), bill);
            return bill;
        }
        return null;
    }
}