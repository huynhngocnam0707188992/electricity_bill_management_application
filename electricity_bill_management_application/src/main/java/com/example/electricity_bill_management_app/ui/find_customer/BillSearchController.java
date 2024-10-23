package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.BillSearchInputBoundary;

public class BillSearchController {

    private BillSearchInputBoundary bsInputB = null;

    public BillSearchController() {
    }

    public BillSearchController(BillSearchInputBoundary bsInputB) {
        this.bsInputB = bsInputB;
    }



    public void execute(){
        bsInputB.excute();
    }
}
