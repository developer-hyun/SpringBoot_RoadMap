package com.example.demo;


import com.example.demo.db.MemoryRepository;
import com.example.demo.db.MemoryRepositoryImpl;
import com.example.demo.member.MemberService;
import com.example.demo.member.memberServiceImpl;
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


}
