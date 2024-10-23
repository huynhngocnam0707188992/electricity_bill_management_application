package com.example;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import com.example.electricity_bill_management_app.database.DeleteBillDAOMemory.DeleteBillDAOMemory;
import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNCustomerType;
import com.example.electricity_bill_management_app.entity.VNElectricBill;
import com.example.electricity_bill_management_app.ui.delete_bill.DeleteBillPresenter;
import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillInputBoundary;
import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillOutputDTO;
import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillUseCase;

public class Delete_Bill_Test {

    @Test
    public void getDeleteBillTestSucsess() {
        DeleteBillDAOMemory database = new DeleteBillDAOMemory(getData());

        DeleteBillPresenter presenter = new DeleteBillPresenter();

        DeleteBillInputBoundary vSLUseCase = new DeleteBillUseCase(presenter, database);

        vSLUseCase.excute();

        List<DeleteBillOutputDTO> listOutDTO = presenter
        .getListOutputDTO();

        assertEquals(4, listOutDTO.size());
        
    }

    private List<ElectricBill> getData() {
        List<ElectricBill> list = new ArrayList<>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            list.add(new VNElectricBill("VN001", 1, 200000, sdf.parse("20/01/2023"), "Nguyen Van A ", VNCustomerType.Business, 1));
            list.add(new VNElectricBill("VN002", 1, 250000, sdf.parse("25/07/2012"), "Nguyen Van B ", VNCustomerType.Production, 1));
            list.add(new ForeignElectricBill("F001", 1, 300000, 1, sdf.parse("14/03/2024"), "Nguyen Van C", "American"));
            list.add(new ForeignElectricBill("F002", 1, 275000, 1, sdf.parse("28/09/2020"), "Nguyen Van D", "Mexico"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

}
