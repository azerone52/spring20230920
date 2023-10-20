package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao5;
import com.example.spring20230920.domain.MyDto36;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("main31")
public class Controller31 {
    private final MyDao5 dao;

    @GetMapping("sub1")
    public void method1(){
        String res1 = dao.select1("mexico");
        System.out.println("res1 = "+res1);

        String res2 = dao.select1(null);
        System.out.println("res2 = " + res2);
    }

    @GetMapping("sub2")
    public void method2(Integer number){
        dao.select2(number);
    }

    // /main31/sub3?code=1&k=ro
    // /main31/sub3?code=2k=ro
    @GetMapping("sub3")
    public void method3(Integer code, String k, Model model){
        //code가 1이면 select customerName, contactName from customers where customerName LIKE '%ro%';
        //code가 2이면 select customerName, contactName from customers where contactName LIKE '%ro%';
        List<Map<String, Objects>> maps = dao.select3(code, "%" + k + "%");

        maps.forEach(System.out::println);
        model.addAttribute("names", maps);
    }

    @GetMapping("sub4")
    public void method4() {
        dao.select4(30);
    }

    @GetMapping("sub5")
    public void method5(MyDto36 dto, Model model){
        model.addAttribute("cityList", dao.listCustomerCity());
        model.addAttribute("countryList", dao.listCustomerCounty());

        model.addAttribute("customerList", dao.listCustomer(dto));
    }
}
