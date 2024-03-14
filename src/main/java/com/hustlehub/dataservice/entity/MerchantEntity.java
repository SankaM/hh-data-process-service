package com.hustlehub.dataservice.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="MERCHANT")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name="USER_ID", length=50, nullable=false)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=50, nullable=true)
    private DepositStatus status;

    @Column(name="APPROVED_BY", length=50)
    private String approvedBy;

    @Column(name="CREATED")
    @Timestamp
    private LocalDateTime createdDate;

    @Timestamp
    @Column(name="UPDATED")
    private LocalDateTime updatedDate;
}
