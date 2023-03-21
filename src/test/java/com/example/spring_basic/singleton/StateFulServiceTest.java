package com.example.spring_basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService bean1 = ac.getBean(StateFulService.class);
        StateFulService bean2 = ac.getBean(StateFulService.class);
        
        //ThreadA : A 사용자가 10000원 주문
        int userAPrice = bean1.order("name",10000);
        //ThreadB : B 사용자가 20000원 주문
        int userbPrice = bean1.order("name",20000);
        
        //ThreadA: 사용자 A 주문 금액 조회
        System.out.println("price = " + userAPrice);
        // 10000원이 아니라 20000원이 나온다. 같은 인스턴스를 사용하기 때문이다.

        //Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);

    }
    
    static class TestConfig{
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }

}