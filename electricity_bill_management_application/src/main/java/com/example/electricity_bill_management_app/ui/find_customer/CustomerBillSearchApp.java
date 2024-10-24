package com.example.electricity_bill_management_app.ui.find_customer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.electricity_bill_management_app.database.SearchBillDAOMemory.BillSearchDAOMemory;
import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNCustomerType;
import com.example.electricity_bill_management_app.entity.VNElectricBill;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchUseCase;

public class CustomerBillSearchApp {
    public static void main(String[] args) {

        BillSearchDAOMemory dataDaoMemory = new BillSearchDAOMemory(getBillList());
        BillSearchPresenter presenter = new BillSearchPresenter();

        BillSearchUseCase deleteBillUseCase = new 
        BillSearchUseCase(presenter, dataDaoMemory);

        BillSearchController controller = 
        new BillSearchController(deleteBillUseCase);

        controller.execute();
    }

    private static List<ElectricBill> getBillList() {
        List<ElectricBill> bill = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            bill.add(new VNElectricBill("VN001", 1, 200000, sdf.parse("11/01/2011"), "Nguyen Van A", VNCustomerType.Residential));
            bill.add(new VNElectricBill("VN002", 1, 250000, sdf.parse("30/10/2021"), "Nguyen Van B", VNCustomerType.Business));
            bill.add(new VNElectricBill("VN003", 1, 300000, sdf.parse("17/07/2019"), "Nguyen Van F", VNCustomerType.Production));
            bill.add(new ForeignElectricBill("F001", 1, 260000, sdf.parse("22/03/2022"), "Nguyen Van C", "American"));
            bill.add(new ForeignElectricBill("F002", 1, 210000, sdf.parse("19/01/2024"), "Nguyen Van D", "Singapore"));
            bill.add(new ForeignElectricBill("F003", 1, 320000, sdf.parse("21/04/2020"), "Nguyen Van E", "Mexico"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bill;
    }
}

