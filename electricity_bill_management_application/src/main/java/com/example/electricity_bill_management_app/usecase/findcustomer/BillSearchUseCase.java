package com.example.electricity_bill_management_app.usecase.findcustomer;

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
    public void execute(BillSearchRequestInput billSearchRequestInput) {
        List<ElectricBill> BillList = bsBillDatabaseBoundary.getBillList();
        List<BillSearchResponesOutput> listOutputDTO = new ArrayList<>();

        for (ElectricBill bill : BillList) {
            String Name = bill.getCustomerName();
            String Bill = bill.getBillID();
            Date BillDate = bill.getBillDate();
            float UnitPrice = bill.getUnitPrice();
            int Quantity = bill.getQuantity();



            BillSearchResponesOutput dBillOutputDTO = new BillSearchResponesOutput(Name, Bill, Quantity, BillDate, UnitPrice);
            listOutputDTO.add(dBillOutputDTO);
        }
       
        bsOutputBoundary.present(listOutputDTO);
    }



   

}
