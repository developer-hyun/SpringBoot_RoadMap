package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class); //memberService 객체가 MemberServiceImpl 타입의 인스턴스인지 검증하는 코드
    }
    @Test
    @DisplayName("타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);  //타입으로 조회는 이름이 불필요  //타입이 여러개일때는?
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class); //memberService 객체가 MemberServiceImpl 타입의 인스턴스인지 검증하는 코드
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class); //memberService 객체가 MemberServiceImpl 타입의 인스턴스인지 검증하는 코드
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
       // MemberService memberService = ac.getBean("memberServiceX",MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->ac.getBean("memberServiceXXX",MemberService.class));
        //"ac.getBean("memberServiceX", MemberService.class)를 실행했을 때 NoSuchBeanDefinitionException이 던져져야 한다" — 예외가 발생해야 테스트 통과
        //
        //즉, 예외가 발생하는 것이 정상임을
    }

}
