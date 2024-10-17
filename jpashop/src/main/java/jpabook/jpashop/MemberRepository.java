package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository  //엔티티같은거 찾아주는거
public class MemberRepository {

    @PersistenceContext  // 엔티티 메니져
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    //조회
    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
