package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import com.example.electricity_bill_management_app.entity.ElectricBill;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchBillUseCaseTest {
    public static void main(String[] args) {
        // Giả lập cơ sở dữ liệu hóa đơn
        @SuppressWarnings("rawtypes")
        BillRepositoryBoundary billDatabase = new MockSearchBillDatabase();
        @SuppressWarnings("unchecked")
        BillSearchUseCase searchBillUseCase = new BillSearchUseCase(billDatabase, new SimpleSearchBillOutputBoundary());

        // Test với mã khách hàng hợp lệ
        System.out.println("Test với mã khách hàng hợp lệ:");
        searchBillUseCase.execute(new BillSearchInputDTO("CUST123"));

        // Test với mã khách hàng không hợp lệ
        System.out.println("\nTest với mã khách hàng không hợp lệ:");
        searchBillUseCase.execute(new BillSearchInputDTO("INVALID_CODE"));

        
    }
}

// Giả lập cho BillRepositoryBoundary
@SuppressWarnings("rawtypes")
class MockSearchBillDatabase implements BillRepositoryBoundary {
    @Override
    public List<ElectricBill> findBillByCustomerCode(String customerCode) {
        List<ElectricBill> bills = new ArrayList<>();
        if ("CUST123".equals(customerCode)) {
            bills.add(createMockBill("BILL001", "John Doe", 350.0f));
        } else if ("CUST456".equals(customerCode)) {
            bills.add(createMockBill("BILL001", "John Doe", 350.0f));
            bills.add(createMockBill("BILL002", "Jane Smith", 600.0f));
        }
        return bills;
    }

    private ElectricBill createMockBill(String billID, String customerName, float totalPrice) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 15);
        Date billDate = calendar.getTime();
        return new ElectricBill(billID, 100, 3.5f, 100, billDate, customerName) {
            @Override
            public float calculated() {
                return totalPrice;
            }
        };
    }
}

// Giả lập cho BillSearchUseCaseOutputBoundary
class SimpleSearchBillOutputBoundary implements BillSearchUseCaseOutputBoundary {
    @Override
    public void present(BillSearchOutputDTO outputDTO) {
        List<ElectricBill> bills = outputDTO.getBills();
        if (bills.isEmpty()) {
            System.out.println("Không tìm thấy hóa đơn nào.");
        } else {
            bills.forEach(bill -> System.out.println("Bill ID: " + bill.getBillID() + ", Customer: " + bill.getCustomerName() + ", Total: " + bill.calculated()));
        }
    }
}
