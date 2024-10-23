package com.example.electricity_bill_management_app.ui.delete_bill;

import java.util.List;

import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillOutputBoundary;
import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillOutputDTO;

public class DeleteBillPresenter implements DeleteBillOutputBoundary {

    private List<DeleteBillOutputDTO> listOutputDTO = null;

    public List<DeleteBillOutputDTO> getListOutputDTO() {
        return listOutputDTO;
        
    }

    @Override
    public void present(List<DeleteBillOutputDTO> listOutputDTO) {
        this.listOutputDTO = listOutputDTO;

        //ViewStudentForm
        DeleteBillForm form = new DeleteBillForm();
        form.createAndShowGUI(listOutputDTO);
    }

}
