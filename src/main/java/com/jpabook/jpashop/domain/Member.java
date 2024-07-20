package com.jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    public Long id;
    

    private String name;

    @Embedded // 내장 타입
    private Address address;
    
    @OneToMany(mappedBy = "member")
    // Best practice : 객체 생성 후 컬렉션 바꾸지 말것(하이버 네이트가 자체적으로 wrapper로 감쌈 : 아래 컬렉션을 )
    private List<Order> orders = new ArrayList<>();  

    // 초기화 방법은 스타일 
    // private List<Order> orders;
    // public Member() {
    //     this.orders  = new ArrayList<>();
    // }

    
}
