package com.jpabook.jpashop;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberRepository_backup {

    @PersistenceContext
    private EntityManager em; 
    
    
    public Long save(Member_backup member) {
        em.persist(member);
        return member.getId();
    }

    public Member_backup find(Long id) {
                return em.find(Member_backup.class, id);
    }
}
