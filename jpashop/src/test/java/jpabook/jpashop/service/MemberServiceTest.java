package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest  //이 두개가 있어야 부트에 올려서 테스트 가능
@Transactional  //한 트랜잭션에서 실행됨 , 안되면 롤백됨
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    @Rollback(false)
    public void join() throws Exception {
        // given  // 조건을 줌
        Member member = new Member();
        member.setName("kim");

        //when  // 이렇게 하면
        Long savedId = memberService.join(member);

        // then  // 이렇게 된다
        em.flush();
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void dupliMember() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2);  //예외가 발생해야 한다!!

        // then
        fail("예외가 발생해야 한다. ");
    }



}