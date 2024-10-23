public class SearchBillUseCase implements BillSearchUseCaseInputBoundary {
  private BillSearchUseCaseOutputBoundary outputBoundary;
  private BillRepositoryBoundary billDatabase;

  public SearchBillUseCase(BillSearchUseCaseOutputBoundary outputBoundary, BillRepositoryBoundary billDatabase) {
      this.outputBoundary = outputBoundary;
      this.billDatabase = billDatabase;
  }

  @Override
  public void execute(String customerCode, int month, int year) {
      List<BillSearchOutputDTO> outputDTOList = new ArrayList<>();
      ElectricBill bill = billDatabase.findBillByCustomerCode(customerCode);
      
      if (bill != null) {
          BillSearchOutputDTO dto = new BillSearchOutputDTO(bill.getBillID(), bill.getCustomerName(), bill.getBillDate(), bill.calculated());
          outputDTOList.add(dto);
      }

      outputBoundary.present(outputDTOList);
  }
}
