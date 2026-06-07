package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    //이렇게 되면 멤버서비스 구현체가 MMR을 직접 연결안하고 기획자인 AppConfig가  MMR을 주입하는식
    //생성자 주입이라고함.
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository() , new FixDiscountPolicy());
    }

}
