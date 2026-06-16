package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

//        @Test
//    @DisplayName("모든 빈 출력")
//    void findAllBean() {
//            String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//            for (String beanDefinitionName : beanDefinitionNames) {
//                Object bean = ac.getBean(beanDefinitionName);
//                System.out.println("name: " + beanDefinitionName + " object = " + bean);
//            }
//        }
        @Test
    @DisplayName("애플리케이션 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //컨테이너에 등록된 모든 빈이름 조회
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);  //BeanDefinition 은 빈 하나하나에 대한 메타정보 //빈이름으로 빈 메타정보 추출해서

            //ROLE_APLL~  : 직접 등록한 애플리케이션 빈
            //Role_ infrast~~ : 스프링 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {  //내가 넣은 빈만 출력해줘  //이 빈의 역활이  내가 등록한 빈의 역활이면  출력
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name: " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
