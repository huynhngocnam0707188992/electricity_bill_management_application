package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;

public class BillSearchUseCase implements BillSearchInputBoundary{

    private BillSearchOutputBoundary bsOutputBoundary = null;
    private BillSearchDatabaseBoundary bsBillDatabaseBoundary = null;


    
    public BillSearchUseCase(BillSearchOutputBoundary bsOutputBoundary,
            BillSearchDatabaseBoundary bsBillDatabaseBoundary) {
        this.bsOutputBoundary = bsOutputBoundary;
        this.bsBillDatabaseBoundary = bsBillDatabaseBoundary;
    }



    @Override
    public void excute() {
        List<ElectricBill> BillList = bsBillDatabaseBoundary.getBillList();
        List<BillSearchOutputDTO> listOutputDTO = new ArrayList<>();

        for (ElectricBill bill : BillList) {
            String Name = bill.getCustomerName();
            String Bill = bill.getBillID();
            Date BillDate = bill.getBillDate();
            float UnitPrice = bill.getUnitPrice();
            int Quantity = bill.getQuantity();



            BillSearchOutputDTO dBillOutputDTO = new BillSearchOutputDTO(Name, Bill, Quantity, BillDate, UnitPrice);
            listOutputDTO.add(dBillOutputDTO);
        }
        ResponseBillList rsDltBillList = new ResponseBillList(BillList);
        bsOutputBoundary.present(listOutputDTO);
    }

}
