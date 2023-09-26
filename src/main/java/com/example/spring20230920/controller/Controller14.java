package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("main14")
public class Controller14 {
    @RequestMapping({"sub1", "sub3"})
    public void method1(){

    }
    //get 방식으로 왔을 때 작동하는 메소드
    @RequestMapping(value = "sub2", method = RequestMethod.GET)
    public void method2(
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ){
        System.out.println("Controller14.method2");
        System.out.println("id = " + id);
        System.out.println("password = " + password);
    }
    //post 방식으로 왔을 때 작동하는 메소드
    @RequestMapping(value = "sub2", method = RequestMethod.POST)
    public void method3(
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ){
        System.out.println("Controller14.method3");
        System.out.println("id = " + id);
        System.out.println("password = " + password);
    }

//    @RequestMapping(value="sub4", method=RequestMethod.POST)
    @PostMapping("sub4")
    public void method4(
            String title,
            String content
    ){
        System.out.println("title = " + title);
        System.out.println("content = " + content);
    }

    @GetMapping("sub5")
    public void method5(){}

    @PostMapping("sub6")
    public void method6(
            String username,
            String password
    ){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
