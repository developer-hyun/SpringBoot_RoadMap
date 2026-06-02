package hello.core.member;

public interface MemberRepository {

    void save(Member member);//값만 저장하니까 void

    Member findById(Long memberId);//고유번호를 받아 해당하는 회원객체를 돌려준다 결과물로 회원객체를 찾아야하기때문에 리턴타입이 Member


}
