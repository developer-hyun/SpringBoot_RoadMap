package SpringBoot_RoadMap.Spring_Introduction.repository;

import SpringBoot_RoadMap.Spring_Introduction.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Re
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++); //아이디는 1씩 늘어남
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //member반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }


//    private static Map<Long, Member> store = new HashMap<>();
//    private static long sequence  = 0L;
//
//    @Override
//    public Member save(Member member) {
//        member.setId(++sequence);
//        store.put(member.getId(), member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id)
//    {
//        return Optional.ofNullable(store.get(id));
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        return store.values().stream()
//                .filter(member -> member.getName().equals(name))
//                .findAny(); //Member에 name이 같은 이름이있으면 반환
//
//
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
}
