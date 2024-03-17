package com.hustlehub.dataservice.entity;

import com.hustlehub.dataservice.dto.Status;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class HustleEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=50, nullable=true)
    private Status status;

    @Column(name="NAME", length=30)
    private String name;

    @Column(name="DESCRIPTION", length=100)
    private String description;

    @Column(name="SAILOR_ID", length=50)
    private String sailorId;

    @Column(name="VALUATION")
    private BigDecimal valuation;

    @Column(name="TOTAL_RETURN_BALANCE")
    private BigDecimal totalReturnBalance;

    @Column(name="CURRENCY")
    private String currency;

    @Column(name="TOTAL_CARD_COUNT")
    private Long totalCardCount;

    @Column(name="SOLD_CARD_COUNT")
    private Long soldCardCount;

    @Column(name="TOTAL_CAPITAL_RAISED")
    private BigDecimal totalCapitalRaised;

    @Column(name="CARD_VALUE")
    private BigDecimal cardValue;

    @Column(name="TENURE")
    private Long tenure;

    @Column(name="TENURE_UNIT")
    private String tenureUnit;

    @Column(name="RETURN_PERIOD")
    private String returnPeriod;

    @Column(name="RETURN_TYPE")
    private String returnType;

    @Column(name="RETURN_VALUE")
    private BigDecimal returnValue;

    @Column(name="TOTAL_RETURN_PER_CARD")
    private BigDecimal totalReturnPerCard;

    @Timestamp
    @Column(name="START_DATE")
    private LocalDateTime startDate;

    @Timestamp
    @Column(name="END_DATE")
    private LocalDateTime endDate;

    @Column(name="APPROVED_BY", length=50)
    private String approvedBy;

    @Column(name="CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name="UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}
