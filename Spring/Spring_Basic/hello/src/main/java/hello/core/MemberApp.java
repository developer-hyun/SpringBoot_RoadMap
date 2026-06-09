package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService= appConfig.memberService();
       // MemberService memberService = new MemberServiceImpl();


        //스프링을 사용하는 버전
        //스프링컨테이너에넣는다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //클래스이름 , 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);



        Member member = new Member(1L,Grade.VIP,"memberA");
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new me" + member.getName());
        System.out.println("find me" + findMember.getName());

    }
}
