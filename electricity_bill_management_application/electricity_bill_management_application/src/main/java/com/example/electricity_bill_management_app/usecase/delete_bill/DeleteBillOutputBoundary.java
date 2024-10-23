package com.example.electricity_bill_management_app.usecase.delete_bill;

import java.util.List;

public interface DeleteBillOutputBoundary {

    void present(List<DeleteBillOutputDTO> listOutputDTO);

}
