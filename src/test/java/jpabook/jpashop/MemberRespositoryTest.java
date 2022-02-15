package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberRespositoryTest {
    @Autowired
    MemberRespository memberRespository;

    @Test
    @Transactional
    @Rollback(value = false)
    void save() {
        Member member = new Member();
        member.setUsername("A");
        Long savedId = memberRespository.save(member);
        Member findMember = memberRespository.find(savedId);
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("(findMember == member) = " + (findMember == member));
    }

    @Test
    void find() {
    }
}