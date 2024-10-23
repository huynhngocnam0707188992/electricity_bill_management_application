package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.List;

public interface BillSearchOutputBoundary {

    void present(List<BillSearchOutputDTO> listOutputDTO);

}
