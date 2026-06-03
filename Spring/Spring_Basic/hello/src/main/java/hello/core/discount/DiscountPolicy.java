package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * 얼마나 할인되었는지 return
     */
    int discount(Member member,int price);
}
