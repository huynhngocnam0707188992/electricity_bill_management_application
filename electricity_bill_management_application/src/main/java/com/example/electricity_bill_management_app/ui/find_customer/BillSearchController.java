public class BillSearchController {
    private BillSearchUseCase useCase;

    public BillSearchController(BillSearchUseCase useCase) {
        this.useCase = useCase;
    }

    public void searchBills(String customerCode) {
        BillSearchInputDTO inputDTO = new BillSearchInputDTO(customerCode);
        useCase.execute(inputDTO);
    }
}
