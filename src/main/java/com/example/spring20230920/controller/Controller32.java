package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao6;
import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import com.example.spring20230920.service.MyService1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("main32")
public class Controller32 {
    private final MyDao6 dao;
    private final MyService1 component;

    @GetMapping("sub1")
    public void method1(MyDto37 dto){
        dao.insert1(dto);

        System.out.println("dto = " + dto);
    }

    // /main32/sub2?lastName=흥민
    @GetMapping("sub2")
    public void method2(MyDto38 dto){
        dao.insert2(dto); //직원 테이블에 lastName 입력

        System.out.println("dto = " + dto); // 새 직원의 번호와 이름 출력
    }

    @GetMapping("sub3")
    public void method3(){

    }
    @PostMapping("sub4")
    public String method4(MyDto38 dto, RedirectAttributes rttr){
        dao.insert3(dto);

        rttr.addFlashAttribute("message", dto.getId() + "번 직원이 등록되었습니다");

        return "redirect:/main32/sub3";
    }

    @GetMapping("sub5")
//    @Transactional
    public void method5(){
        try{
//            dao.update1();
//
//            int c = 1/0; // runtimeException
//
//            dao.update2();
            component.tx1(); // 이런 형태로 해야만 콘솔창에서도 10000 10000
        }finally {
            System.out.println("dao.select3() = " + dao.select3());// 주석 경우 여기까지 실행되고 rollback
        }
    }

}
