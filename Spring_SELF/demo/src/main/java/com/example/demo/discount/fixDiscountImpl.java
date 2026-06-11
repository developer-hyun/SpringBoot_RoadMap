package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;

public class fixDiscountImpl implements discountPolicy{

    private int fixdiscountprice=1000;
    @Override
    public int discountPrice(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return fixdiscountprice;
        }
        else{
            return 0;
        }
    }
}
