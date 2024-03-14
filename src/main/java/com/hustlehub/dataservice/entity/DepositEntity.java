package com.hustlehub.dataservice.entity;

import com.hustlehub.dataservice.dto.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="DEPOSIT")
@Getter
@Setter
public class DepositEntity {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name="USER_ID", length=50, nullable=false)
    private String userId;

    @Column(name="COUNTY", length=50, nullable=false)
    private String country;

    @Column(name="CURRENCY", length=50, nullable=false)
    private String currency;

    @Column(name="AMOUNT", length=50, nullable=false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=50, nullable=false)
    private DepositStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name="PAYMENT_TYPE", length=50, nullable=false)
    private PaymentType paymentType;

    @Column(name="APPROVED_BY", length=50)
    private String approvedBy;

    @Column(name="CREATED", length=50, nullable=false)
    private LocalDateTime createdDate;

    @Column(name="UPDATED", length=50)
    private LocalDateTime updatedDate;
}
