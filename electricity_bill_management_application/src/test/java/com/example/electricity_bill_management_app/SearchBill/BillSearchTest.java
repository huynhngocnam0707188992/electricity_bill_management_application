package com.example.electricity_bill_management_app.SearchBill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.electricity_bill_management_app.database.SearchBillDAOMemory.BillSearchDAOMemory;
import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNCustomerType;
import com.example.electricity_bill_management_app.entity.VNElectricBill;
import com.example.electricity_bill_management_app.ui.find_customer.BillSearchPresenter;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchInputBoundary;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchResponesOutput;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchRequestInput;
import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchUseCase;

public class BillSearchTest {
    

    // Trường hợp test thành công: tìm kiếm theo mã hóa đơn hợp lệ "VN001"
    @Test
    void getSearchTest() {
        
        BillSearchDAOMemory database = new BillSearchDAOMemory(getData());

        BillSearchPresenter presenter = new BillSearchPresenter();

        BillSearchInputBoundary bsIUseCase = new BillSearchUseCase(presenter, database);

        BillSearchRequestInput billSearchRequestInput = new BillSearchRequestInput("VN001");
       
        bsIUseCase.execute(billSearchRequestInput);
        

        List<BillSearchResponesOutput> listOutDTO = presenter
        .getListOutputDTO();

        assertEquals(1, listOutDTO.size()); // Số lượng kết quả phải là 1
        assertEquals("VN001", listOutDTO.get(0).getCustomerCode()); // Kiểm tra mã khách hàng
        
    }

    // Trường hợp test lỗi: không tìm thấy hóa đơn với mã không tồn tại "VN999"
    @Test
    void getSearchTest_notFound() {
        
        BillSearchDAOMemory database = new BillSearchDAOMemory(getData());

        BillSearchPresenter presenter = new BillSearchPresenter();

        BillSearchInputBoundary billSearchUseCase = new BillSearchUseCase(presenter, database);

        // Tìm với mã hóa đơn không tồn tại
        BillSearchRequestInput billSearchRequestInput = new BillSearchRequestInput("VN999");
       
        billSearchUseCase.execute(billSearchRequestInput);
        
       
        List<BillSearchResponesOutput> listOutDTO = presenter.getListOutputDTO();
       
        assertEquals(0, listOutDTO.size());
    }

    

    // Hàm cung cấp dữ liệu mẫu
    private List<ElectricBill> getData() {
        List<ElectricBill> list = new ArrayList<>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            list.add(new VNElectricBill("VN001", 1, 200000, sdf.parse("11/01/2011"), "Nguyen Van A", VNCustomerType.Residential));
            list.add(new VNElectricBill("VN002", 1, 250000, sdf.parse("30/10/2021"), "Nguyen Van B", VNCustomerType.Business));
            list.add(new VNElectricBill("VN003", 1, 300000, sdf.parse("17/07/2019"), "Nguyen Van F", VNCustomerType.Production));
            list.add(new ForeignElectricBill("F001", 1, 260000, sdf.parse("22/03/2022"), "Nguyen Van C", "American"));
            list.add(new ForeignElectricBill("F002", 1, 210000, sdf.parse("19/01/2024"), "Nguyen Van D", "Singapore"));
            list.add(new ForeignElectricBill("F003", 1, 320000, sdf.parse("21/04/2020"), "Nguyen Van E", "Mexico"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
