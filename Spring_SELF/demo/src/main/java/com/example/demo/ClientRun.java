package com.example.demo;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientRun {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberService memberService =  applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member memberA = new Member(1L,"memberA", Grade.VIP);
        Member memberB = new Member(2L,"memberB", Grade.Basic);

        memberService.join(memberA);
        memberService.join(memberB);
        Member findMember = memberService.findMember(2L);
        System.out.println("new me" + memberA.getName());
        System.out.println("find me" + findMember.getName());


        Order orderA = orderService.createOrder("닭다리",1L,20000);
        System.out.println(orderA.toString());
    }


}
