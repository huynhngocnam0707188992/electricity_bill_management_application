package com.example.electricity_bill_management_app.ui.delete_bill;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.electricity_bill_management_app.database.DeleteBillDAOMemory.DeleteBillDAOMemory;
import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNCustomerType;
import com.example.electricity_bill_management_app.entity.VNElectricBill;
import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillUseCase;

public class DeleteBillMain {

    public static void main(String[] args) {

        DeleteBillDAOMemory dataDaoMemory = new DeleteBillDAOMemory(getBillList());
        DeleteBillPresenter presenter = new DeleteBillPresenter();

        DeleteBillUseCase deleteBillUseCase = new 
        DeleteBillUseCase(presenter, dataDaoMemory);

        DeleteBillController controller = 
        new DeleteBillController(deleteBillUseCase);

        controller.execute();
    }

    private static List<ElectricBill> getBillList() {
        List<ElectricBill> bill = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            bill.add(new VNElectricBill("VN001", 1, 200000, sdf.parse("20/01/2023"), "Nguyen Van A ", VNCustomerType.Business, 1));
            bill.add(new VNElectricBill("VN002", 1, 250000, sdf.parse("25/07/2012"), "Nguyen Van B ", VNCustomerType.Production, 1));
            bill.add(new ForeignElectricBill("F001", 1, 300000, 1, sdf.parse("14/03/2024"), "Nguyen Van C", "American"));
            bill.add(new ForeignElectricBill("F002", 1, 275000, 1, sdf.parse("28/09/2020"), "Nguyen Van D", "Mexico"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bill;
    }

}
