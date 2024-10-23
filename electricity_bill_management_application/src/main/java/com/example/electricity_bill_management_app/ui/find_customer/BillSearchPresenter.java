package com.example.electricity_bill_management_app.ui.find_customer;

import java.util.List;

import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.BillSearchOutputBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.BillSearchOutputDTO;



public class BillSearchPresenter implements BillSearchOutputBoundary {

    private List<BillSearchOutputDTO> listOutputDTO = null;

    public List<BillSearchOutputDTO> getListOutputDTO() {
        return listOutputDTO;
        
    }

    @Override
    public void present(List<BillSearchOutputDTO> listOutputDTO) {
        this.listOutputDTO = listOutputDTO;

        //ViewStudentForm
        BillSearchForm form = new BillSearchForm();
        form.createAndShowGUI(listOutputDTO);
    }
}
