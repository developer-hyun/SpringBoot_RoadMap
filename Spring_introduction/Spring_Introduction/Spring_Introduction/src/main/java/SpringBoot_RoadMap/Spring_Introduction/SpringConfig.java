package SpringBoot_RoadMap.Spring_Introduction;


import SpringBoot_RoadMap.Spring_Introduction.repository.MemberRepository;
import SpringBoot_RoadMap.Spring_Introduction.repository.MemoryMemberRepository;
import SpringBoot_RoadMap.Spring_Introduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
