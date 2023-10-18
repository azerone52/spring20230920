package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao3;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@RequestMapping("main29")
public class Controller29 {
    private final MyDao3 dao3;

    @GetMapping("sub1")
    public void method1(){
        String name = dao3.select1();
        System.out.println("name = " + name);
    }

    @GetMapping("sub2")
    public void method2(){
        Double price = dao3.select2();
        System.out.println("price = " + price);
    }

    @GetMapping("sub3")
    public void method3(){
        // 1번 직원의 LastName 조회 후 출력
        String lastName = dao3.select3();
        System.out.println("lastName = " + lastName);
    }

    @GetMapping("sub4")
    public void method4(){
        LocalDate birthDate = dao3.select4();
        System.out.println("birthDate = " + birthDate);
    }

    // 하나 행 여러 열
    @GetMapping("sub5")
    public void method5(){
        List<String> countries = dao3.select5();

        countries.forEach(System.out::println);
    }

    @GetMapping("sub6")
    public void method6(){
        // 직원들의 생일 조회
        List<LocalDate> birthDates = dao3.select6();

        birthDates.forEach(System.out::println);
    }

    // 여러 행 여러 열
    @GetMapping("sub7")
    public void method7(){
        List<Map<String, Double>> products = dao3.select7();
        products.forEach(System.out::println);
    }

    //여러 행 하나의 열
    @GetMapping("sub8")
    public void mehtod8(){
        // Map은 순서가 보장되지 않으므로 순서는 다르게 나옴
        Map<String, Object> row = dao3.select8();
        System.out.println("row = " + row);
    }
    @GetMapping("sub9")
    public void method9(){
        // 1번 상품의 상품명, 가격, 카테고리명
        Map<String, Object> products = dao3.select9();
        System.out.println("products = " + products);
        products.entrySet().forEach(System.out::println);
    }

    @GetMapping("sub10")
    public void method10() {
        MyDto19 myDto19 = dao3.select10();
        System.out.println("myDto19 = " + myDto19);
    }

    @GetMapping("sub11")
    public void method11(){
        MyDto20 dto = dao3.select11();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub12")
    public void method12(){
        MyDto21 dto = dao3.slect12();
        // 2번 고객의 id, name, country
        System.out.println("dto = " + dto);
    }
    // 여러 행 여러 열
    @GetMapping("sub13")
    public void method13(){
        List<Map<String, Object>> rows = dao3.select13();
        for(Map<String, Object> row : rows){
            System.out.println("row = " + row);
        }
    }

    @GetMapping("sub14")
    public void method14(){
        List<Map<String, Object>> maps = dao3.select14();
        // 1996-07-04에 주문된 상품명, 상품의 수량, 상품의 가격

        maps.forEach(System.out::println);
    }
    @GetMapping("sub15")
    public void method15(){
        List<MyDto22> maps = dao3.select15();
        // 1996-07-04에 주문된 상품명, 상품의 수량, 상품의 가격

        maps.forEach(System.out::println);
    }

    //sub16 요청시
    // 1번 카테고리 상품들이 주문된 날짜, 상품명, 카테고리명, 수량, 가격
    // 날짜와 상품명 순으로 정렬
    @GetMapping("sub16")
    public void method16(){
        List<Map<String, Object>> maps = dao3.select16();

        maps.forEach(System.out::println);

        System.out.println("maps.size() = " + maps.size());
    }

    //자주 보는 오류

    // 조회된 게 없는 경우: null
    @GetMapping("sub17")
    public void method17(){
        String s = dao3.select17();
        System.out.println("s = " + s);
    }

    @GetMapping("sub18")
    public void method18(){
        Integer s = dao3.select18();
        //int가 아닌 Integer로 두면 Exception 발생 x
        System.out.println("s = " + s);
    }

    @GetMapping("sub19")
    public void method19(){
        MyDto24 dto24 = dao3.select19();
        System.out.println("dto24 = " + dto24);
    }

    @GetMapping("sub20")
    public void method20(){
        //하나의 레코드만 받을 수 있는 리턴타입으로
        // 레코드를 여러개 보내면 오류가 남
        MyDto24 dto24 = dao3.select20();
        System.out.println("dto24 = " + dto24);
    }
}