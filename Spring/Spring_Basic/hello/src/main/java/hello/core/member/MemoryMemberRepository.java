package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{ //implements 구현한다.
    //static가 없다면 MMR객체를 새로 만들때마다 store가 빔.
   private static Map<Long,Member> store = new HashMap<>();//실무에선 동시성 ConcurrentHashMap사용

    @Override
    //MemberRep 를 구현하는 MemoryMembeRep기때문에 MRep에 있는 save와 findById의구현
    //Oberride는 부모메서드 재정의
    public void save(Member member) {
            store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //Member객체 반환
    }
}
