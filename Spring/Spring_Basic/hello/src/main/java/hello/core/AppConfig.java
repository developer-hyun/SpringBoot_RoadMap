package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //이렇게 되면 멤버서비스 구현체가 MMR을 직접 연결안하고 기획자인 AppConfig가  MMR을 주입하는식
    //생성자 주입이라고함.
//    public MemberService memberService() {
//
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    //config 안에서도 역할과 구현을 나눔
    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
