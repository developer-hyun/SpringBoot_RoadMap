package com.example.demo.discount;

import com.example.demo.member.Member;

public interface discountPolicy {

    int discountPrice(Member member ,int price);
}
