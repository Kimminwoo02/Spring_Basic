package com.example.spring_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class SingletonTest {
    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        System.out.println("bean2 = " + bean2);
        System.out.println("bean1 = " + bean1);
        Assertions.assertThat(bean1).isSameAs(bean2);

        ac.close();
    }
    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void destory(){
            System.out.println("SignletonBean.Destory");
        }

    }


    @Test
    @DisplayName("비밀번호가 최소 8자 이상 12자 이하이면 예외 x")
    void validatePasswordTest(){
        assertThatCode(() ->Passwordvalidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }
}
