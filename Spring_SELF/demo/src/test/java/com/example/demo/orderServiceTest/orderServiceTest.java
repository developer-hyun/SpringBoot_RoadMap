package com.example.demo.orderServiceTest;

import com.example.demo.Appconfig;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class orderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
        orderService = appconfig.orderService();
    }

    @Test
    void order() {

        Member member =  new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

      //  Order order = new Order("itemA",1L,10000);
        Order orderA =orderService.createOrder("itemA",1L,10000);
        System.out.println(orderA);
    }

}
