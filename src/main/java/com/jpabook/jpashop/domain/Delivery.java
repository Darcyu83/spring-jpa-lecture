package com.jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
     
    @OneToOne(mappedBy = "delivery" ,fetch = FetchType.LAZY)
    private Order order;
    
    @Embedded
    private Address address;

    // @Enumerated(EnumType.ORDINAL) // 숫자로 DB에 저장: 되도록이면 쓰지 말자 
    @Enumerated(EnumType.STRING) // 스트링으로 저장 
    private DeliveryStatus status; // READY, CMP




}
