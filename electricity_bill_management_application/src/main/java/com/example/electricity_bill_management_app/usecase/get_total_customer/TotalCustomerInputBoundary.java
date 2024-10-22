package com.example.electricity_bill_management_app.usecase.get_total_customer;

import com.example.electricity_bill_management_app.usecase.get_total_customer.DTO.TotalCustomerInputDTO;

public interface TotalCustomerInputBoundary {

    public void execute(TotalCustomerInputDTO totalCustomerInputDTO);

}
