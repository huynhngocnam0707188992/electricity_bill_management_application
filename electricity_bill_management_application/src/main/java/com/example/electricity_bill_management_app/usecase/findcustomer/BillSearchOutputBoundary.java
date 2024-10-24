package com.example.electricity_bill_management_app.usecase.findcustomer;

import java.util.List;

public interface BillSearchOutputBoundary {

    void present(List<BillSearchResponesOutput> listOutputDTO);

}
