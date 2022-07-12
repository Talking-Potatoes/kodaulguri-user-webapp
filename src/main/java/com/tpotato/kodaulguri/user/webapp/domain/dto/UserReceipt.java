package com.tpotato.kodaulguri.user.webapp.domain.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserReceipt {
  public long userReceiptId;
  public long userId;
  public long userShoppingBasketId;
  public String name;
  public Timestamp visitTime;
  public String ordererName;
  public String ordererPhoneNumber;
  public String ordererRequirement;
  public char paymentType;
  public long price;
  public Timestamp createdDatetime;
  public Timestamp updatedDatetime;
}
