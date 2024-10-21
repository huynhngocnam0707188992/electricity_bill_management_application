package com.example.testfind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.electricity_bill_management_app.database.BillDAOMemory;
import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.ui.find_customer.FindCustomerPresenter;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.FindCustomerInputBoundary;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.FindCustomerUseCase;
import com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer.SearchBillOutputDTO;

public class FindCustomerTest {

    private FindCustomerInputBoundary findCustomerInputBoundary;
    private FindCustomerPresenter presenter;
    private BillDAOMemory billDAO;

    @BeforeEach
    public void setUp() {
        billDAO = new BillDAOMemory(); // Sử dụng DAO bộ nhớ
        presenter = new FindCustomerPresenter();
        findCustomerInputBoundary = new FindCustomerUseCase(presenter, billDAO);

        // Thêm hóa đơn mẫu vào BillDAO
        billDAO.addBill(getMockBill("BILL001", "Nguyen Van A"));
        billDAO.addBill(getMockBill("BILL002", "Nguyen Van B"));
    }

    @Test
    public void testFindBillByID_ExistingID() {
        String billID = "BILL001";
        findCustomerInputBoundary.execute(billID);
        
        List<SearchBillOutputDTO> foundBills = presenter.getListOutputDTO();

        // Kiểm tra rằng hóa đơn được tìm thấy là hóa đơn với ID "BILL001"
        assertEquals(1, foundBills.size());
        assertEquals("BILL001", foundBills.get(0).getBillID());
        assertEquals("Nguyen Van A", foundBills.get(0).getCustomerName());
    }

    @Test
    public void testFindBillByID_NonExistingID() {
        String billID = "BILL999";
        findCustomerInputBoundary.execute(billID);
        
        List<SearchBillOutputDTO> foundBills = presenter.getListOutputDTO();

        // Kiểm tra rằng không có hóa đơn nào được tìm thấy
        assertEquals(0, foundBills.size());
    }

    @Test
    public void testFindBillByCustomerName_ExistingName() {
        String customerName = "Nguyen Van A";
        findCustomerInputBoundary.executeByCustomerName(customerName);
        
        List<SearchBillOutputDTO> foundBills = presenter.getListOutputDTO();

        // Kiểm tra rằng hóa đơn được tìm thấy là của khách hàng "Nguyen Van A"
        assertEquals(1, foundBills.size());
        assertEquals("Nguyen Van A", foundBills.get(0).getCustomerName());
    }

    @Test
    public void testFindBillByCustomerName_NonExistingName() {
        String customerName = "Nguyen Van C";
        findCustomerInputBoundary.executeByCustomerName(customerName);
        
        List<SearchBillOutputDTO> foundBills = presenter.getListOutputDTO();

        // Kiểm tra rằng không có hóa đơn nào được tìm thấy
        assertEquals(0, foundBills.size());
    }

    private ElectricBill getMockBill(String billID, String customerName) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.OCTOBER, 22); // Ngày tạo hóa đơn
        Date billDate = calendar.getTime();

        // Tạo đối tượng hóa đơn mẫu
        return new ElectricBill(billID, 100, 1500f, 200, billDate, customerName);
    }
}
