package com.api.carrentalapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass   // Entity sınıflarında temel-ortak tablo elemanlarını (id, soft-delete, updatedate, insertdate vs.) belirlemek için kullanılır.
@EntityListeners(AuditingEntityListener.class) //Kaydın ne zaman, hangi kullanıcı tarafından güncellendiği bilgilerini takip eder.
public abstract class Auditable {

    @CreatedBy
    @Column(name = "CreatedBy")
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP) // Alanın hem tarih, hem de zaman bileşenlerini içermesi gerektiğini belirtir.
    @CreatedDate
    @Column(name = "CreatedDate")
    protected Date createdDate;

    @LastModifiedBy
    @Column(name = "LastModifiedBy")
    protected String lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "LastModifiedDate")
    protected Date lastModifiedDate;

}
