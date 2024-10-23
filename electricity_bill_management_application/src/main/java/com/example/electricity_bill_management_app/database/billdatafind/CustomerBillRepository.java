import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.electricity_bill_management_app.entity.ElectricBill;
import com.example.electricity_bill_management_app.entity.ForeignElectricBill;
import com.example.electricity_bill_management_app.entity.VNCustomerType;
import com.example.electricity_bill_management_app.entity.VNElectricBill;

public class CustomerBillRepository {
    private List<ElectricBill> billList = new ArrayList<>();

    public CustomerBillRepository() {
        // Simulating some data
        billList.add(new VNElectricBill("001", "Nguyen Van A", 150, VNCustomerType.Residential));
        billList.add(new ForeignElectricBill("002", "John Doe", 200, "USA"));
        billList.add(new VNElectricBill("003", "Tran Thi B", 100, VNCustomerType.BUSINESS));
    }

    public List<ElectricBill> findBillByCustomerCode(String customerCode) {
        return billList.stream()
                .filter(bill -> bill.getBillID().equals(customerCode))
                .collect(Collectors.toList());
    }
}
