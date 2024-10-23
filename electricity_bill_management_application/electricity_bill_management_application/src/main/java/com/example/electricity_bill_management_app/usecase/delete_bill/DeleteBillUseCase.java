package com.example.electricity_bill_management_app.usecase.delete_bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.electricity_bill_management_app.entity.ElectricBill;


public class DeleteBillUseCase implements DeleteBillInputBoundary {
    private DeleteBillOutputBoundary dltOutputBoundary = null;
    private DeleteBillDatabaseBoundary dltBillDatabaseBoundary = null;



    public DeleteBillUseCase(DeleteBillOutputBoundary dltOutputBoundary,
            DeleteBillDatabaseBoundary dltBillDatabaseBoundary) {
        this.dltOutputBoundary = dltOutputBoundary;
        this.dltBillDatabaseBoundary = dltBillDatabaseBoundary;
    }




    @Override
    public void excute() {
        List<ElectricBill> BillList = dltBillDatabaseBoundary.getBillList();
        List<DeleteBillOutputDTO> listOutputDTO = new ArrayList<>();

        for (ElectricBill bill : BillList) {
            String Name = bill.getCustomerName();
            String Bill = bill.getBillID();
            Date BillDate = bill.getBillDate();
            float UnitPrice = bill.getUnitPrice();
            int Quantity = bill.getQuantity();



            DeleteBillOutputDTO dBillOutputDTO = new DeleteBillOutputDTO(Name, Bill, Quantity, BillDate, UnitPrice);
            listOutputDTO.add(dBillOutputDTO);
        }
        ResponseDeleteList rsDltBillList = new ResponseDeleteList(BillList);
        dltOutputBoundary.present(listOutputDTO);
    }

    

}
