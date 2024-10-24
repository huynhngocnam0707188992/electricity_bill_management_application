package com.example.electricity_bill_management_app.ui.find_customer;

import java.util.List;

import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchOutputBoundary;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchResponesOutput;



public class BillSearchPresenter implements BillSearchOutputBoundary {

    private List<BillSearchResponesOutput> listOutputDTO = null;

    public List<BillSearchResponesOutput> getListOutputDTO() {
        return listOutputDTO;
        
    }

    @Override
    public void present(List<BillSearchResponesOutput> listOutputDTO) {
        this.listOutputDTO = listOutputDTO;

        //ViewStudentForm
        BillSearchForm form = new BillSearchForm();
        form.createAndShowGUI(listOutputDTO);
    }
}
