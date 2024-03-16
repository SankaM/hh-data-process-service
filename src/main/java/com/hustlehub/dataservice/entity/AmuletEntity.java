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

@Entity
@Table(name="HUSTLES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AmuletEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name="VOYAGER_ID", nullable = false)
    private String voyagerId;
    @Column(name="HUSTLE_ID", nullable = false)
    private String hustleId;
    @Column(name="INVESTED_AMOUNT", nullable = false)
    private BigDecimal investedAmount;
    @Column(name="PURCHASED_CARD_COUNT", nullable = false)
    private Long purchasedCardCount;
    @Column(name="PER_CARD_VALUE", nullable = false)
    private BigDecimal cardValue;
    @Column(name="START_DATE")
    private LocalDateTime startDate;
    @Column(name="END_DATE")
    private LocalDateTime endDate;
    @Column(name="NEXT_RETURN_DATE")
    private LocalDateTime nextReturnDate;
    @Column(name="NEXT_RETURN_AMOUNT")
    private BigDecimal nextReturnAmount;
    @Column(name="CURRENT_TOTAL_RETURN")
    private BigDecimal currentTotalReturnReceived;
    @Column(name="TOTAL_RETURN_EXPECTED", nullable = false)
    private BigDecimal totalReturnExpected;
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=20, nullable=false)
    private Status status;

    @Column(name="CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name="UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}
