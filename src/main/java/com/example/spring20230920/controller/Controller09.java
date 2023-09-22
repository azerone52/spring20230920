package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto7;
import com.example.spring20230920.domain.MyDto8;
import com.example.spring20230920.domain.MyDto9;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
@RequestMapping("main9")
public class Controller09 {
    @RequestMapping("sub1")
    public void method1(Model model){
        model.addAttribute("attr1","son");
        model.addAttribute("attr2", 300);
        model.addAttribute("attr3", true);
        model.addAttribute("attr4", 3.14);

        //모델속성이 배열일 경우
        model.addAttribute("attr5", new String[]{"lee","kim"});

        String[] myArr1 = {"korea","seoul","jeju"};
        model.addAttribute("yourArr6",myArr1);

    }

    @RequestMapping("sub2")
    public void method2(Model model){
        String[] names = {"kim", "lee","bak"};
        String[] yourEmail = {"abc1@google.com","abc2@google.com","abc3@google.com"};
        String[] herAddress = {"seoul","jeju","busan"};

        model.addAttribute("myName",names);
        model.addAttribute("yourEmail",yourEmail);
        model.addAttribute("herAddress", herAddress);
    }

    @RequestMapping("sub3")
    public void method3(Model model){
        model.addAttribute("names", List.of("두식","봉석","희수"));

        model.addAttribute("list1", List.of("리스트1","리스트2"));
        model.addAttribute("mapList1", List.of("korea","japan","us"));
        model.addAttribute("cities",new String[]{"seoul","daejun","busan","jeonju"});
    }

    @RequestMapping("sub4")
    public void method4(Model model){
        var map1 = Map.of("son",7,"lee",19,"kim",30);

        model.addAttribute("myMap",map1);

        var cityMap = Map.of("seoul","수육국밥","busan","돼지국밥");
        var color = Map.of("red","빨간색","blue","파란색","black","검은색");
        model.addAttribute("cityMap", cityMap);
        model.addAttribute("color", color);

        var map3 = Map.of(
                "name","두식",
                "my name","봉석",
                "your-name","희수"
        );
        model.addAttribute("attr3", map3);
    }

    @RequestMapping("sub5")
    public void method5(Model model){
        var map1 = Map.of("phone1","iphone","phone2","galaxy");
        var map2 = Map.of("korea","seoul","us","ny");
        var map3 = Map.of("1st","hamburger","2nd","pizza");

        model.addAttribute("korea", "us");
        model.addAttribute("phones", map1);
        model.addAttribute("caps",map2);
        model.addAttribute("foods",map3);
    }

    @RequestMapping("sub6")
    public void method6(Model model){
        model.addAttribute("attr1", new Object());
        model.addAttribute("attr2", new Scanner(System.in));
        model.addAttribute("attr3", new MyDto7());
    }

    @RequestMapping("sub7")
    public void method7(Model model){
        MyDto8 o1 = new MyDto8();
        o1.setFood("pizza");
        o1.setComputer("intel");
        o1.setBirthDate("2020-01-01");

        model.addAttribute("person1", o1);
    }

    @RequestMapping("sub8")
    public void method8(Model model){
        MyDto9 student = new MyDto9();
        student.setId("kim");
        student.setFirstName("재원");
        student.setLastName("김");
        student.setClassName("자바");
        student.setPhoneNumber("010-2222-3333");

        model.addAttribute("student",student);
    }
}
