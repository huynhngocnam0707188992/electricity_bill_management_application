package com.example.electricity_bill_management_app.entity;

import java.util.Date;

public class ForeignElectricBill extends ElectricBill {
  private String nationality;

  public ForeignElectricBill(String billID, int quantity, float unitPrice, Date billDate,
      String customerName, String nationality) {
    super(billID, quantity, unitPrice, billDate, customerName);
    this.nationality = nationality;
  }

  public ForeignElectricBill(String string, String string2, int i, String string3) {
    //TODO Auto-generated constructor stub
}

public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public float calculated() {
    this.totalPrice = quantity * unitPrice;
    return this.totalPrice;
  };
}
