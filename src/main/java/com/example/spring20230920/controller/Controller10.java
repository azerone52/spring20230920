package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto10;
import com.example.spring20230920.domain.MyDto9;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {
    @RequestMapping("sub1")
    public void method1(Model model){
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();
        MyDto9 o3 = new MyDto9();
        MyDto9 o4 = new MyDto9();

        o1.setFirstName("son");
        o2.setFirstName("lee");
        o3.setFirstName("bak");
        o4.setFirstName("kim");

        model.addAttribute("students", List.of(o1,o2,o3,o4));
    }

    @RequestMapping("sub2")
    public void method2(Model model){
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();

        o1.setLastName("두식");
        o2.setLastName("봉석");

        model.addAttribute("personMap",
                Map.of("person1", o1,"person2",o2));

        model.addAttribute("people",
                Map.of("1st", o1, "2nd",o2));
    }

    @RequestMapping("sub3")
    public void method3(Model model){
        MyDto10 o1 = new MyDto10();
        o1.setName("doosik");
        o1.setId(3);
        o1.setFoods(List.of("pizza", "burger","milk"));
        o1.setCars(List.of("bmw", "benzz","huyndae"));

        model.addAttribute("person1",o1);

    }

    @RequestMapping("sub4")
    public void method4(Model model){
        model.addAttribute("myList", List.of("tesla","kia","benz"));
    }

    @RequestMapping("sub5")
    public void method5(Model model){
        model.addAttribute("foodList", List.of("salad","stake","cookie","cake"));
        model.addAttribute("names",List.of("두식","봉석","희수","미현"));
    }

    @RequestMapping("sub6")
    public void method6(Model model){
        List<MyDto9> list=new ArrayList<>();
        list.add(new MyDto9("31","son","hm","football","010"));
        list.add(new MyDto9("32","lee","ki","football","011"));
        list.add(new MyDto9("33","kim","doosik","basketball","012"));
        list.add(new MyDto9("34","bak","suhyun","basketball","013"));
        list.add(new MyDto9("35","baek","euna","baseball","014"));

        model.addAttribute("moving",list);
    }

    @RequestMapping("sub7")
    public void method7(Model model){
        model.addAttribute("a", 2);
        model.addAttribute("b", 5);

        model.addAttribute("c", "8");
        model.addAttribute("d", "9");

        model.addAttribute("gu", List.of(9,8,7,6,5,4,3,2));
    }

    @RequestMapping("sub8")
    public void method8(Model model){
        model.addAttribute("a", 3);
        model.addAttribute("b", 5);

        model.addAttribute("c", "java");
        model.addAttribute("d", "spring");

        model.addAttribute("e", "11");
        model.addAttribute("f", "2");
        model.addAttribute("g", 2);
        //${e > f} : false
        //${e > g} : true
    }

    @RequestMapping("sub9")
    public void method9(Model model){
        model.addAttribute("a", "java");
        model.addAttribute("b","");

        model.addAttribute("c", List.of(3,4));
        model.addAttribute("d",List.of());

        model.addAttribute("e", Map.of("name", "son"));
        model.addAttribute("f", Map.of());

        model.addAttribute("g",null);
    }
}
