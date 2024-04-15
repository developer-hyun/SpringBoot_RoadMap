package SpringBoot_RoadMap.Spring_Introduction.repository;

import SpringBoot_RoadMap.Spring_Introduction.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach //테스트 클래스마다 종료시 이전기록을 지워주는 용도
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

//    MemberRepository repository = new MemoryMemberRepository();
//
//    @Test
//    public void save() {
//        Member member = new Member();
//        member.setName("Spring");
//        repository.save(member);
//        Member result =repository.findById(member.getId()).get();
//      //  Assertions.assertEquals(result,member);
//        Assertions.assertThat(member).isEqualTo(result);
//    }
//
//
//    @Test
//    public void findByName() {
//
//    }
}
