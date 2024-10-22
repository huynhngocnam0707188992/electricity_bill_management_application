package com.example.electricity_bill_management_app.usecase.get_total_customer.DTO;


public class TotalCustomerOutputDTO {
   private String customerCategory;
   private int customerQuantity;
   
public TotalCustomerOutputDTO(String customerCategory, int customerQuantity) {
    this.customerCategory = customerCategory;
    this.customerQuantity = customerQuantity;
}
public String getCustomerCategory() {
    return customerCategory;
}
public int getCustomerQuantity() {
    return customerQuantity;
}


   
}
