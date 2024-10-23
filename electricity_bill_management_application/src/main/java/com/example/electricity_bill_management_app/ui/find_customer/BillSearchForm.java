import java.util.Scanner;

public class BillSearchForm {
    private BillSearchController controller;

    public BillSearchForm(BillSearchController controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer code to search for bills:");
        String customerCode = scanner.nextLine();

        controller.searchBills(customerCode);
    }
}
