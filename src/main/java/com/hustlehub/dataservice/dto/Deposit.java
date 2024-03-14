package com.hustlehub.dataservice.dto;

import lombok.Data;

@Data
public class Deposit {
    private String country;
    private String currency;
    private String amount;
    private Status status;
    private PaymentType paymentType;
    private String approvedBy;
    private String createdDate;
    private String updatedDate;
}
