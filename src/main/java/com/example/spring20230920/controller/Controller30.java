package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao4;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("main30")
public class Controller30 {
    private final MyDao4 dao;

    @GetMapping("sub1")
    public void method1(Integer id){
        String name = dao.select1(id);
        System.out.println("name = " + name);
    }

    @GetMapping("sub2")
    public void method2(Double from, Double to){
        List<String> names = dao.select2(from, to);
        names.forEach(System.out::println);
    }

    @GetMapping("sub3")
    public void method3(LocalDate from, LocalDate to){
        List<String> list = dao.select3(from, to);
        list.forEach(System.out::println);

        System.out.println(list.size());
    }

    @GetMapping("sub4")
    public void method4(MyDto25 dto){
        List<String> list = dao.select4(dto);
        System.out.println("list.size() = " + list.size());
    }

    // /main30/sub5?country1=germany&country2=france
    @GetMapping("sub5")
    public void method5(MyDto26 dto){
        // 두 나라에 사는 고객명들 출력
        List<String> list = dao.select5(dto);
        list.forEach(System.out::println);
    }

    // /main30/sub6?from=1996-09-01&to=1996-09-30
    @GetMapping("sub6")
    public void method6(MyDto27 dto1, MyDto28 dto2){
        Integer i = dao.select6(dto1, dto2);
        System.out.println("i = " + i);
    }

    // /main30/sub7?page=2&rows=10&keyword=a
    @GetMapping("sub7")
    public void method7(MyDto29 dto1, MyDto30 dto2){
         /*
        SELECT customerName
        FROM customers
        WHERE customerName LIKE '%a%'
        LIMIT 10, 10
         */
        dto1.setFrom((dto1.getPage()-1)*dto1.getRows());
        dto2.setKeyword("%"+dto2.getKeyword() +"%");
        List<String> names = dao.select7(dto1, dto2);
        names.forEach(System.out::println);
    }


    // insert
    @GetMapping("sub8")
    public void method8(MyDto31 dto) {

        int row = dao.insert1(dto);

        System.out.println(row + "행이 입력되었습니다.");
    }

    @GetMapping("sub9")
    public void method9() {

    }

    @PostMapping("sub10")
    public void method10(MyDto32 emp) {
        int row = dao.insert2(emp);
        System.out.println(row + "행이 입력됨");
    }

    // delete
    // /main30/sub11?id=5
    @GetMapping("sub11")
    public void method11(Integer id){
        int rows = dao.delete1(id);
        System.out.println(rows+ "개 행이 지워짐");
    }

    // /main30/sub12?pid=3
    // 3번 상품이 삭제되는 메소드 완성
    //  dao에 delete2메소드도 작성
    @GetMapping("sub12")
    public void method12(Integer pid){
        int rows = dao.delete2(pid);

        System.out.println("rows = " + rows);
    }

    // /main30/sub13?id=2
    @GetMapping("sub13")
    public void method13(Integer id, Model model){
        // 직원 조회
        MyDto33Employee employee = dao.select8(id);

        model.addAttribute("employee", employee);
    }
    @PostMapping("sub14")
    public String method14(MyDto33Employee employee, RedirectAttributes rttr){
        //직원 수정
        int rows = dao.update1(employee);

        //모델에 추가
        if(rows ==1 ){
            rttr.addFlashAttribute("message", "정보가 수정되었습니다.");
        }else{
            rttr.addFlashAttribute("message", "정보가 수정되지 않았습니다.");
        }
        //쿼리 스트링 추가
        rttr.addAttribute("id", employee.getId());

        return "redirect:/main30/sub13";
    }

    // 고객 정보를 조회하고 수정
    @GetMapping("sub15")
    public void method15(Integer id, Model model){
        MyDto34Customer customer =  dao.select9(id);

        model.addAttribute("customer", customer);
    }
    @PostMapping("sub15")
    public String method15(MyDto34Customer customer, RedirectAttributes rttr){
        int row = dao.update2(customer);

        if(row == 1){
            rttr.addFlashAttribute("message", "고객 정보가 수정되었습니다.");
        }else{
            rttr.addFlashAttribute("message","고객 정보가 수정되지 못했습니다.");
        }

        rttr.addAttribute("id", customer.getCustomerId());

        return "redirect:/main30/sub15";
    }
}
