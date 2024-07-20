package com.jpabook.jpashop;






import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
@SpringJUnitConfig //@RunWith -> @ExtendWith(SpringExtension.class)
public class MemberRepositoryTests {

    @Autowired
    MemberRepository_backup memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception{
        //given 
        Member_backup member = new Member_backup();
        member.setUsername("tester");
   
        //when 
        Long savedId = memberRepository.save(member);
        
        //then
        Member_backup findMember = memberRepository.find(savedId);
        Assertions.assertThat(findMember.getId()).isEqualTo(savedId);
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
    }
}
