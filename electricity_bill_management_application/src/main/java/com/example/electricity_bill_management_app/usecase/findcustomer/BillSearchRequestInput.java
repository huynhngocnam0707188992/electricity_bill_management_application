package com.example.electricity_bill_management_app.usecase.findcustomer;

public class BillSearchRequestInput {
private String billID;

public BillSearchRequestInput(String billID) {
    this.billID = billID;
}

public String getBillID() {
    return billID;
}
}
