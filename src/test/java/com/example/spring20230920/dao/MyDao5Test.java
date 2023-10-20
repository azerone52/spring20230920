package com.example.spring20230920.dao;

import com.example.spring20230920.Spring20230920Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Spring20230920Application.class)
class MyDao5Test {
    @Autowired
    MyDao5 dao;
    @Test
    void select5() {
        dao.select5();
    }
    // 테스트를 위해 해당 클래스의 빈을 먼저 만들고 테스트를 진행하기 때문에,
    // 다른 메소드에서 빈이 만들어지지 않았을 때 오류 발생됨
    @Test
    void select6() {
        dao.select6();
    }

    @Test
    void select7test1(){
        dao.select7(List.of("mexico","uk"));
    }

    @Test
    void select7test2(){
        dao.select7(List.of("mexico","uk", "usa"));
    }

    @Test
    void select8test1(){
        dao.select8(List.of("uk", "usa", "korea"));
    }

    @Test
    void select8test2(){
        dao.select8(List.of());
    }

    @Test
    void select9test1(){
        dao.select9("%"+"com"+"%");
    }
    @Test
    void select9test2(){
        dao.select9("com");
    }

    @Test
    void select10test1(){
        dao.select10("abc");
    }
    @Test
    void select10test2(){
        dao.select10("def");
    }
    @Test
    void select10test3(){
        dao.select10("q");
    }
    @Test
    void select10test4(){
        dao.select10("k");
    }
}