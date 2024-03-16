package com.hustlehub.dataservice.entity;

import com.hustlehub.dataservice.dto.Status;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="SAILOR")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SailorEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name="USER_ID", length=50, nullable=false)
    private String userId;

    @Column(name="TAG", length=10, nullable=false)
    private String tag;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=50, nullable=true)
    private Status status;

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
