package com.example.electricity_bill_management_app.usecase.get_total_customer.DTO;

public class TotalCustomerInputDTO {

    private String customerCategory;

    public TotalCustomerInputDTO(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    

}
