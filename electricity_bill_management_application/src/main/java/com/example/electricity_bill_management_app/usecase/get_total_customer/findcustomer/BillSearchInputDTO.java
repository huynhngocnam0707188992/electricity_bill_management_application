package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

public class BillSearchInputDTO {
    private String customerCode;

    public BillSearchInputDTO(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }
}
