public class CustomerBillSearchApp {
    public static void main(String[] args) {
        CustomerBillRepository repository = new CustomerBillRepository();
        BillSearchUseCase useCase = new BillSearchUseCase(repository);
        BillSearchController controller = new BillSearchController(useCase);
        BillSearchForm form = new BillSearchForm(controller);

        form.start();
    }
}
