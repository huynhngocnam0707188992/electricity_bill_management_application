package com.example.electricity_bill_management_app.usecase.get_total_customer;

import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNCustomerType;
import com.example.electricity_bill_management_app.entity.VNElectricBill;
import com.example.electricity_bill_management_app.database.get_total_customer.TotalCustomerDAOMemory;
import com.example.electricity_bill_management_app.ui.get_total_customer.TotalCustomerPresenter;
import com.example.electricity_bill_management_app.usecase.get_total_customer.DTO.TotalCustomerInputDTO;
import com.example.electricity_bill_management_app.usecase.get_total_customer.DTO.TotalCustomerOutputDTO;

public class TotalCustomerUseCaseTest {
    @Test
    public void testExecuteVN() {
        
        TotalCustomerDatabaseBoundary totalCustomerDatabaseBoundary=new TotalCustomerDAOMemory(getData());
        TotalCustomerPresenter totalCustomerOutputBoundary=new TotalCustomerPresenter();
        TotalCustomerInputDTO totalCustomerInputDTO = new TotalCustomerInputDTO("VN");
        TotalCustomerUseCase totalCustomerUseCase=new TotalCustomerUseCase(totalCustomerDatabaseBoundary,totalCustomerOutputBoundary);
        
        totalCustomerUseCase.execute(totalCustomerInputDTO);
         
        TotalCustomerOutputDTO totalCustomerOutputDTO =totalCustomerOutputBoundary.getTotalCustomerOutputDTO();
        int customerQuantity = totalCustomerOutputDTO.getCustomerQuantity();
        String customerCategory=totalCustomerOutputDTO.getCustomerCategory();

        assertEquals(4,customerQuantity);
        assertEquals("VN",customerCategory);
        
    }


    @Test
    public void testExecuteForeign() {
        TotalCustomerDatabaseBoundary totalCustomerDatabaseBoundary=new TotalCustomerDAOMemory(getData());
        TotalCustomerPresenter totalCustomerOutputBoundary=new TotalCustomerPresenter();
        TotalCustomerInputDTO totalCustomerInputDTO = new TotalCustomerInputDTO("Foreign");
        TotalCustomerUseCase totalCustomerUseCase=new TotalCustomerUseCase(totalCustomerDatabaseBoundary,totalCustomerOutputBoundary);
        
        totalCustomerUseCase.execute(totalCustomerInputDTO);
         
        TotalCustomerOutputDTO totalCustomerOutputDTO =totalCustomerOutputBoundary.getTotalCustomerOutputDTO();
        int customerQuantity = totalCustomerOutputDTO.getCustomerQuantity();
        String customerCategory=totalCustomerOutputDTO.getCustomerCategory();

        assertEquals(4,customerQuantity);
        assertEquals("Foreign",customerCategory);
        
    }


    private Map<String, ElectricBill> getData() {
        Map<String, ElectricBill> billMap = new HashMap<>();
        
        // Tạo ngày cho các hóa đơn
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(1984, Calendar.NOVEMBER, 13);
        Date date1 = calendar1.getTime();
    
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2000, Calendar.SEPTEMBER, 9);
        Date date2 = calendar2.getTime();
    
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2001, Calendar.AUGUST, 8);
        Date date3 = calendar3.getTime();
    
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2002, Calendar.JANUARY, 1);
        Date date4 = calendar4.getTime();
    
        // Tạo các đối tượng hóa đơn
        ElectricBill vnBill1 = new VNElectricBill("VN001", 100, 1.5f, date1, "Nguyen Van A", VNCustomerType.Business, 120);
        ElectricBill vnBill2 = new VNElectricBill("VN002", 200, 1.2f, date2, "Nguyen Van B", VNCustomerType.Production, 150);
        ElectricBill vnBill3 = new VNElectricBill("VN003", 150, 1.8f, date3, "Nguyen Thi C", VNCustomerType.Production, 130);
        ElectricBill vnBill4 = new VNElectricBill("VN004", 250, 2.0f, date4, "Tran Van Mít", VNCustomerType.Residential, 160);
        
        ElectricBill foreignBill1 = new ForeignElectricBill("FR001", 150, 2.0f, 100, date1, "John Doe", "USA");
        ElectricBill foreignBill2 = new ForeignElectricBill("FR002", 175, 2.5f, 120, date2, "Jane Smith", "UK");
        ElectricBill foreignBill3 = new ForeignElectricBill("FR003", 100, 1.75f, 90, date3, "Carlos Garcia", "Mexico");
        ElectricBill foreignBill4 = new ForeignElectricBill("FR004", 130, 2.2f, 110, date4, "Anna Müller", "Germany");
    
        // Thêm vào Map
        billMap.put(vnBill1.getBillID(), vnBill1);
        billMap.put(vnBill2.getBillID(), vnBill2);
        billMap.put(vnBill3.getBillID(), vnBill3);
        billMap.put(vnBill4.getBillID(), vnBill4);
        
        billMap.put(foreignBill1.getBillID(), foreignBill1);
        billMap.put(foreignBill2.getBillID(), foreignBill2);
        billMap.put(foreignBill3.getBillID(), foreignBill3);
        billMap.put(foreignBill4.getBillID(), foreignBill4);
        
        return billMap;
    }
    
}

