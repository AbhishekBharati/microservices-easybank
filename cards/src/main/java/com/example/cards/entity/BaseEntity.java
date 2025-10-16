package com.example.cards.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

//    @CreatedDate
    private LocalDateTime createdAt;

//    @CreatedBy
    private String createdBy;

//    @LastModifiedDate
    private LocalDateTime updatedAt;

//    @LastModifiedBy
    private String updatedBy;
}
