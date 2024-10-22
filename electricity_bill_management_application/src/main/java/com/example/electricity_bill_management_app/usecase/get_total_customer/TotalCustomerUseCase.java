package com.example.electricity_bill_management_app.usecase.get_total_customer;

import com.example.electricity_bill_management_app.usecase.get_total_customer.DTO.TotalCustomerInputDTO;
import com.example.electricity_bill_management_app.usecase.get_total_customer.DTO.TotalCustomerOutputDTO;



public class TotalCustomerUseCase implements TotalCustomerInputBoundary {
  private TotalCustomerDatabaseBoundary totalCustomerDatabaseBoundary = null;
  private TotalCustomerOutputBoundary totalCustomerOutputBoundary = null;

  public TotalCustomerUseCase(TotalCustomerDatabaseBoundary totalCustomerDatabaseBoundary,
      TotalCustomerOutputBoundary totalCustomerOutputBoundary) {
    this.totalCustomerDatabaseBoundary = totalCustomerDatabaseBoundary;
    this.totalCustomerOutputBoundary = totalCustomerOutputBoundary;
  }

  @Override
  public void execute(TotalCustomerInputDTO totalCustomerInputDTO) {
    // TODO Auto-generated method stub
    String customerCategory = totalCustomerInputDTO.getCustomerCategory();
    int customerQuantity;
    TotalCustomerOutputDTO totalCustomerOutputDTO = null;

    customerQuantity = totalCustomerDatabaseBoundary.getTotalCusByCategory(customerCategory);
    totalCustomerOutputDTO = new TotalCustomerOutputDTO(customerCategory, customerQuantity);

    totalCustomerOutputBoundary.presenter(totalCustomerOutputDTO);

  }

}
