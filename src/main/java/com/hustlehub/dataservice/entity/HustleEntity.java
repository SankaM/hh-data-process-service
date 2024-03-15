package com.hustlehub.dataservice.entity;

import com.hustlehub.dataservice.dto.Status;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="HUSTLES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HustleEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=50, nullable=true)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name="NAME", length=30, nullable=true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="DESCRIPTION", length=100, nullable=true)
    private Status description;

    @Enumerated(EnumType.STRING)
    @Column(name="SAILOR_ID", length=50, nullable=true)
    private UUID sailorId;

    @Enumerated(EnumType.STRING)
    @Column(name="VALUATION", nullable=true)
    private BigDecimal valuation;

    @Enumerated(EnumType.STRING)
    @Column(name="CURRENCY", nullable=true)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name="CARD_COUNT", nullable=true)
    private Long cardCount;

    @Enumerated(EnumType.STRING)
    @Column(name="CARD_VALUE", nullable=true)
    private BigDecimal cardValue;

    @Enumerated(EnumType.STRING)
    @Column(name="TENURE", nullable=true)
    private Long tenure;

    @Enumerated(EnumType.STRING)
    @Column(name="TENURE_UNIT", nullable=true)
    private Long tenureUnit;

    @Enumerated(EnumType.STRING)
    @Column(name="RETURN_PERIOD", nullable=true)
    private String returnPeriod;

    @Enumerated(EnumType.STRING)
    @Column(name="RETURN_TYPE", nullable=true)
    private String returnType;

    @Enumerated(EnumType.STRING)
    @Column(name="RETURN_VALUE", nullable=true)
    private Long returnValue;

    @Timestamp
    @Column(name="START_DATE")
    private LocalDateTime startDate;

    @Timestamp
    @Column(name="END_DATE")
    private LocalDateTime endDate;

    @Column(name="APPROVED_BY", length=50)
    private String approvedBy;

    @Column(name="CREATED_AT")
    @Timestamp
    private LocalDateTime createdDate;

    @Timestamp
    @Column(name="UPDATED_AT")
    private LocalDateTime updatedDate;
}
