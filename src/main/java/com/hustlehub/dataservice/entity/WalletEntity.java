package com.hustlehub.dataservice.entity;

import com.hustlehub.dataservice.dto.PaymentType;
import com.hustlehub.dataservice.dto.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="WALLETS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class WalletEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name="VOYAGER_ID", length=50, nullable=false)
    private String voyagerId;

    @Column(name="CURRENCY", length=3, nullable=false)
    private String currency;

    @Column(name="BALANCE", nullable=false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=50, nullable=true)
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
