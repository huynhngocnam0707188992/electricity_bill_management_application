package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchInputBoundary;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchRequestInput;

public class BillSearchController {

    private BillSearchInputBoundary bsInputB = null;
    private BillSearchRequestInput billSearchRequestInput;
    

    public BillSearchController() {
    }

    public BillSearchController(BillSearchInputBoundary bsInputB) {
        this.bsInputB = bsInputB;
    }



    public void execute(){
        bsInputB.execute(billSearchRequestInput);;
    }
}
