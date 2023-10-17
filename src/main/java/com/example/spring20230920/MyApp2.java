package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp2 {
    public static void main(String[] args) {
       //스프링부트어플리케이션실행방법
       ApplicationContext context = SpringApplication.run(MyApp2.class, args);
        // 인스턴스 직접 만들 필요 없이 컴포넌트 어노테이션이 붙은 것의 인스턴스를 자동으로 만들어줌

        Object bean1 = context.getBean("myInstance2"); // spring bean
        System.out.println(bean1 instanceof MyClass2);// true
        MyClass2 o1 = (MyClass2) bean1; // true가 나왔으므로 안전하게 형변환 가능
        o1.method2();

        Object bean3 = context.getBean("myBean3"); // spring bean
        System.out.println(bean3 instanceof MyClass3);// true
        MyClass3 o3 = (MyClass3) bean3;

        // 스프링이 만든 인스턴스 : spring bean

        // 같은 이름으로 꺼내면 항상 같은 객체
        System.out.println(System.identityHashCode(context.getBean("myBean3")));
        System.out.println(System.identityHashCode(context.getBean("myBean3")));
        System.out.println(System.identityHashCode(context.getBean("myBean3")));

        System.out.println(System.identityHashCode(context.getBean("myInstance2")));
        System.out.println(System.identityHashCode(context.getBean("myInstance2")));


        // 형 변환도 자동으로 해주는 메소드
        MyClass2 bean22 = context.getBean("myInstance2", MyClass2.class);
        System.out.println("자동형변환 해쉬코드: "+System.identityHashCode(bean22));
    }
}
@Component("myBean3")
class MyClass3{}
@Component("myInstance2")
class MyClass2 {
    public void method2(){
        System.out.println("MyClass2.method2");
    }
}
