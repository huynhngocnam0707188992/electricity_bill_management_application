package com.example.electricity_bill_management_app.ui.get_total_customer;

import com.example.electricity_bill_management_app.usecase.get_total_customer.TotalCustomerOutputBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.DTO.TotalCustomerOutputDTO;

public class TotalCustomerPresenter implements TotalCustomerOutputBoundary {
     
    TotalCustomerOutputDTO totalCustomerOutputDTO=null;


    @Override
    public void presenter(TotalCustomerOutputDTO totalCustomerOutputDTO) {
        // TODO Auto-generated method stub
        this.totalCustomerOutputDTO=totalCustomerOutputDTO;
        
    }
    

    public TotalCustomerOutputDTO getTotalCustomerOutputDTO(){
        return this.totalCustomerOutputDTO;
    }
}
