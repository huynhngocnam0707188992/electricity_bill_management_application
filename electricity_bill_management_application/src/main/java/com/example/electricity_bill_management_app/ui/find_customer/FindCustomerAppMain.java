package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.database.BillDAO; // Giả định bạn đã có lớp DAO này
import com.example.electricity_bill_management_app.usecase.FindCustomerInputBoundary;
import com.example.electricity_bill_management_app.usecase.FindCustomerUseCase;

public class FindCustomerAppMain {

    public static void main(String[] args) {
        FindCustomerForm findCustomerForm = new FindCustomerForm();
        FindCustomerPresenter presenter = new FindCustomerPresenter(findCustomerForm);
        BillDAO billDAO = new BillDAO(); // Lớp DAO để truy vấn hóa đơn
        FindCustomerInputBoundary findCustomerInputBoundary = new FindCustomerUseCase(presenter, billDAO);

        FindCustomerController controller = new FindCustomerController(findCustomerInputBoundary);
        
        findCustomerForm.createAndShowGUI(); // Hiển thị UI
    }
}
