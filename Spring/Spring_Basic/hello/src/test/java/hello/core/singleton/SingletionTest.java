package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletionTest {

    @Test
    @DisplayName("스프링 없는 순수항 DI컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2
        MemberService memberService2 = appConfig.memberService();
        //참조값이 다른것
        System.out.println(memberService1);
        System.out.println(memberService2);
        //1과 2는 다르다
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletionService singletonService1 = SingletionService.getInstance();
        SingletionService singletonService2 = SingletionService.getInstance();

        System.out.println(singletonService1);
        System.out.println(singletonService2);

        //1과 2는 같다
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("실글톤 패턴을 적용한 객체 사용")
    void
}
