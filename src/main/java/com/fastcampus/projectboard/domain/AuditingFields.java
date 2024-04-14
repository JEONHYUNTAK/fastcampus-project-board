package com.fastcampus.projectboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
//entity에서 상속을 해서 사용해야 하는 목적에 더 잘 맞게 abstract 키워드 추가 별도 이슈 없이 작업함
public abstract class AuditingFields {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_At; // 생성일시

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 100)
    private String created_By; // 생성자

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    LocalDateTime modified_At; // 수정일시

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modified_By; // 수정자
}
