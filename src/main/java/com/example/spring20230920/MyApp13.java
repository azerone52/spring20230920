package com.example.spring20230920;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp13 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp13.class,args);
    }
}
@Component
class MyClass26{
    // dependency injection 이후에 실행
    // 실행 시 스프링 작동 콘솔 위에서 세번째 줄에 흔적이 남음->그 때 실행된다
    @PostConstruct
    public void method1(){
        System.out.println("MyClass26.method1");
    }
}
