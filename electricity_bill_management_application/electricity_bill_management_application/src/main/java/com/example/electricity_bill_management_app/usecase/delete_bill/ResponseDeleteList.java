package com.example.electricity_bill_management_app.usecase.delete_bill;

import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;


public class ResponseDeleteList implements ResponseData {

    private String message = "GET_LIST_OK";
    private List<ElectricBill> list = null;

    public ResponseDeleteList(List<ElectricBill> list) {
        this.list = list;
    }

    public List<ElectricBill> geList() {
        return list;
    }

    public String getMessage() {
        return message;
    }
}
