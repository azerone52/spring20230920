package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8")
public class Controller08 {
    @RequestMapping("sub1")
    public void method1(Model model){
        model.addAttribute("attr1","value1");
        model.addAttribute("attr2","value2");
        // forward to /WEB-INF/jsp/main8/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method2(Model model){
        model.addAttribute("propOne","😎😎");
        model.addAttribute("propTwo","😂😂");
    }
    @RequestMapping("sub3")
    public void method3(Model model){
        model.addAttribute("myName","홍길동");
        model.addAttribute("yourAddress","seoul");
        model.addAttribute("herEmail","abc@google.com");
    }
}
