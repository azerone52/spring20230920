package com.example.spring20230920;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp6 {
    public static void main(String[] args) {
        // Inversion Of Control (IOC) : 스프링이 우리의 제어를 가져감
        // Spring -> IOC Container
        ApplicationContext context = SpringApplication.run(MyApp6.class, args);

        MyClass9 myClass9 = context.getBean("myClass9", MyClass9.class);
        myClass9.method9(); // NullPointerException->@Autowired를 넣으면 발생 x

        System.out.println("myClass9.getField1() = " + myClass9.getField1());//com.example.spring20230920.MyClass10@7f6329cb
        Object myClass10 = context.getBean("myClass10");
        System.out.println("myClass10 = " + myClass10);//com.example.spring20230920.MyClass10@7f6329cb
    }
}

@Component // myClass10
class MyClass10{
    public void method10(){
        System.out.println("MyClass10.method10");
    }
}
@Component // myClass9
class MyClass9{
    // 마이클래스9가 10을 의존: 마이클래스10 필드를 가지고 있음
    private MyClass10 field1; // dependency
    // field1 에 값을 넣기 위해 생성자나 set 메소드가 필요

    public MyClass9() {
    }

//    @Autowired // 생성자 주입
    public MyClass9(MyClass10 field1) {
        this.field1 = field1;
    }
    // Dependency Injection(DI, 의존성 주입)
    // 메소드 주입
    @Autowired // 필드를 넣으라고 명시
    public void setField1(MyClass10 field1) {
        this.field1 = field1;
    }

    public MyClass10 getField1() {
        return field1;
    }

    public void method9(){
        field1.method10();
    }

}
