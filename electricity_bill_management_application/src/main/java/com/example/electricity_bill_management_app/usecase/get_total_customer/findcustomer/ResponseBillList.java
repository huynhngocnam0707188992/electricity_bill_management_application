package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;

public class ResponseBillList implements ResponseData{
    private String message = "GET_LIST_OK";
    private List<ElectricBill> list = null;

    public ResponseBillList(List<ElectricBill> list) {
        this.list = list;
    }

    public List<ElectricBill> geList() {
        return list;
    }

    public String getMessage() {
        return message;
    }
}

