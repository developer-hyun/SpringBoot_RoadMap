package com.example.demo;


import com.example.demo.db.MemoryRepository;
import com.example.demo.db.MemoryRepositoryImpl;
import com.example.demo.discount.discountPolicy;
import com.example.demo.discount.fixDiscountImpl;
import com.example.demo.member.MemberService;
import com.example.demo.member.memberServiceImpl;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    public MemberService memberService() {
        return new memberServiceImpl(memoryRepository());
    }

    @Bean
    public MemoryRepository memoryRepository() {
        return new MemoryRepositoryImpl();
    }

    @Bean
    public OrderService orderService()
    {return new OrderServiceImpl(memoryRepository(),discountPolicyA()) ;
    }
    @Bean
    public discountPolicy discountPolicyA() {
        return new fixDiscountImpl();
    }
}
