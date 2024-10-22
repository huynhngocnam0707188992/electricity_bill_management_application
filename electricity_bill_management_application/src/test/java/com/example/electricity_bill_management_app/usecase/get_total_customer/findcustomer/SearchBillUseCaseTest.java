package com.example.electricity_bill_management_app.usecase.get_total_customer.findcustomer;

import com.example.electricity_bill_management_app.entity.ElectricBill;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchBillUseCaseTest {
    public static void main(String[] args) {
        // Khởi tạo các đối tượng cần thiết
        SearchBillDatabaseBoundary billDatabase = new MockSearchBillDatabase();
        SearchBillOutputBoundary outputBoundary = new MockSearchBillOutputBoundary();
        SearchBillUseCase searchBillUseCase = new SearchBillUseCase(outputBoundary, billDatabase);

        // Test với mã khách hàng hợp lệ
        System.out.println("Test với mã khách hàng hợp lệ:");
        searchBillUseCase.execute("CUST123", 0, 0);
        outputBoundary.present(null); // In kết quả

        // Test với mã khách hàng không hợp lệ
        System.out.println("\nTest với mã khách hàng không hợp lệ:");
        searchBillUseCase.execute("INVALID_CODE", 0, 0);
        outputBoundary.present(null); // In kết quả

        // Test với mã khách hàng có nhiều hóa đơn
        System.out.println("\nTest với mã khách hàng có nhiều hóa đơn:");
        searchBillUseCase.execute("CUST456", 0, 0);
        outputBoundary.present(null); // In kết quả
    }
}

// Giả lập cho SearchBillDatabaseBoundary
class MockSearchBillDatabase implements SearchBillDatabaseBoundary {
    @Override
    public ElectricBill findBillByCustomerCode(String customerCode) {
        switch (customerCode) {
            case "CUST123":
                return getMockBill();
            case "CUST456":
                List<ElectricBill> bills = new ArrayList<>();
                bills.add(getMockBill());
                bills.add(getMockBillWithDifferentCustomer("BILL002", "Jane Smith"));
                return (ElectricBill) bills;
            default:
                return null;
        }
    }

    private ElectricBill getMockBill() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        Date billDate = calendar.getTime();

        return new ElectricBill("BILL001", 100, 3.5f, 100, billDate, "John Doe") {
            @Override
            public float calculated() {
                return 350.0f;
            }
        };
    }

    private ElectricBill getMockBillWithDifferentCustomer(String billID, String customerName) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        Date billDate = calendar.getTime();

        return new ElectricBill(billID, 150, 4.0f, 120, billDate, customerName) {
            @Override
            public float calculated() {
                return 600.0f; // Giả sử tính toán khác
            }
        };
    }

    @Override
    public List<SearchBillOutputDTO> findBillsByMonthAndYear(int month, int year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBillsByMonthAndYear'");
    }
}

// Giả lập cho SearchBillOutputBoundary
class MockSearchBillOutputBoundary implements SearchBillOutputBoundary {
    private List<SearchBillOutputDTO> results = new ArrayList<>();

    @Override
    public void present(List<SearchBillOutputDTO> outputDTOs) {
        this.results = outputDTOs;
        System.out.println("Kết quả:");
        for (SearchBillOutputDTO dto : outputDTOs) {
            System.out.println("Bill ID: " + dto.getBillID() + ", Customer Name: " + dto.getCustomerName());
        }
    }

    public void present() {
        System.out.println("Kết quả:");
        for (SearchBillOutputDTO dto : results) {
            System.out.println("Bill ID: " + dto.getBillID() + ", Customer Name: " + dto.getCustomerName());
        }
    }
}
