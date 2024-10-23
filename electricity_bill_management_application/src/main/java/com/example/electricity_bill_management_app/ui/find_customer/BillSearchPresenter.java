public class BillSearchPresenter implements BillSearchUseCaseOutputBoundary {
    @Override
    public void present(BillSearchOutputDTO outputDTO) {
        if (outputDTO.getBills().isEmpty()) {
            System.out.println("No bills found for the given customer code.");
        } else {
            outputDTO.getBills().forEach(bill -> {
                System.out.println("Bill ID: " + bill.getBillID());
                System.out.println("Customer Name: " + bill.getCustomerName());
                System.out.println("Total Price: " + bill.getTotalPrice());
                System.out.println("-----------------------------");
            });
        }
    }
}
