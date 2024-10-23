package com.example.electricity_bill_management_app.ui.delete_bill;

import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillInputBoundary;

public class DeleteBillController {

    private DeleteBillInputBoundary viewSLInputB = null;

    public DeleteBillController() {
    }

    public DeleteBillController(DeleteBillInputBoundary viewSLInputB) {
        this.viewSLInputB = viewSLInputB;
    }

    public void execute(){
        viewSLInputB.excute();
    }

}
