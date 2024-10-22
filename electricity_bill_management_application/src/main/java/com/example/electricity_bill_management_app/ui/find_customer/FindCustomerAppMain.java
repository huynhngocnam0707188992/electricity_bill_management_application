package com.example.electricity_bill_management_app.ui.find_customer;

import com.example.electricity_bill_management_app.database.billdatafind.BillDAO; // Lớp DAO
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillInputBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillUseCase;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillOutputBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillDatabaseBoundary;

public class FindCustomerAppMain {

    public static void main(String[] args) {
        FindCustomerForm findCustomerForm = new FindCustomerForm();
        FindCustomerPresenter presenter = new FindCustomerPresenter(findCustomerForm);
        
        // Khởi tạo BillDAO để sử dụng làm database
        BillDAO billDAO = new BillDAO(); // BillDAO thực hiện interface SearchBillDatabaseBoundary
        
        // Khởi tạo các interface cần thiết
        SearchBillOutputBoundary outputBoundary = presenter; // Chuyển presenter để hiển thị kết quả
        SearchBillDatabaseBoundary databaseBoundary = billDAO; // Sử dụng BillDAO làm database

        //Khởi tạo SearchBillUseCase
       SearchBillInputBoundary findCustomerInputBoundary = new SearchBillUseCase(outputBoundary, databaseBoundary);

        //Khởi tạo controller với input boundary
       FindCustomerController controller = new FindCustomerController(findCustomerInputBoundary);
        
        findCustomerForm.createAndShowGUI(); // Hiển thị UI
    }
}
