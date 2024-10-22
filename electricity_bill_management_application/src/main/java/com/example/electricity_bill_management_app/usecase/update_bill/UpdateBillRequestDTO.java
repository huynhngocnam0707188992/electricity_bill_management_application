package com.example.electricity_bill_management_app.usecase.update_bill;

import java.util.Date;
import java.util.List;

public class UpdateBillRequestDTO {
    private String id;
    private String customerName;
    private double amount;
    private String description;
    private List<UpdateBillResponseDTO> items;
    private String updatedBy;
    private Date updatedAt;

    public UpdateBillRequestDTO(String id, String customerName, double amount, 
                              String description, List<UpdateBillResponseDTO> items,
                              String updatedBy, Date updatedAt) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
        this.description = description;
        this.items = items;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<UpdateBillResponseDTO> getItems() { return items; }
    public void setItems(List<UpdateBillResponseDTO> items) { this.items = items; }
    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}