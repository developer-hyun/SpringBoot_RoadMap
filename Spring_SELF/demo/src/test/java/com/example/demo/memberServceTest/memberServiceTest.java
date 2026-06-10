package com.example.demo.memberServceTest;

import com.example.demo.Appconfig;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class memberServiceTest {


    @BeforeEach
    public void beforeEach() {
        Appconfig appconfig = new Appconfig();
        MemberService memberService = appconfig.memberService();
    }

    @Test
    void join() {
        Member member =  new Member(1L,"memberA", Grade.VIP);


    }
}
