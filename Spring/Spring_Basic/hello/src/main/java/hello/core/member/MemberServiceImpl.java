package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //좌 - 인터페이스타입 구격으로 변수설정하고 우-객체로 MMR을함
    //좌를 MMR로 안한건 인터페이스로 해야 DBMMR로 바꼇을때 좌를 안바꿔도됨. 역할과 내용물의관계
    //나중에 new MMR도 없는게 의존관계주입
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
