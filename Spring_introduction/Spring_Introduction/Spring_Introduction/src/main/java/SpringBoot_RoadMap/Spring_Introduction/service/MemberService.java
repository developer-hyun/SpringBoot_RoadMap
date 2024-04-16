package SpringBoot_RoadMap.Spring_Introduction.service;


import SpringBoot_RoadMap.Spring_Introduction.domain.Member;
import SpringBoot_RoadMap.Spring_Introduction.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Serv
public class MemberService {
    //테스트 코드 작성 커맨드 쉬프트 t
    private final MemberRepository memberRepository;

    //@Auto
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //이름 중복 x
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); //ifpresent = 값이 있으면
        //optional단축키 커맨트 알트 V
        //method 추출 단축키 커맨트 알트 B
        memberRepository.findByName(member.getName())
        .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }); //ifpresent = 값이 있으면
    }

    /**
     * 전체 멤버 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
