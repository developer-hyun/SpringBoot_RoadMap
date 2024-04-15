package SpringBoot_RoadMap.Spring_Introduction.repository;

import SpringBoot_RoadMap.Spring_Introduction.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);  //회원멤버 저장
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();



}

//public interface MemberRepository {
//
//    Member save(Member member);
//    Optional<Member> findById(Long id) ;
//    Optional<Member> findByName(String name); //null을 반환할 경우에 있을때 요즘엔 Optional로 감싸서 반환
//    List<Member> findAll();
//}
