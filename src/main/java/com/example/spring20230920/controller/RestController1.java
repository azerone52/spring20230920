package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto34Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
//@ResponseBody//모든메소드에적용
@RestController //@Controller+@ResponseBody
@RequiredArgsConstructor
@RequestMapping("api/main1")
public class RestController1 {
    private final MyDao10 dao;

    @GetMapping("sub1")
//    @ResponseBody 생략 가능
    public String method1(){
        return "hello boot app!!";
    }

    @GetMapping("sub2")
    @ResponseBody
    public String method2(){
        //5번 고객의 customerName 응답
        return dao.select(6);
    }

    @GetMapping("sub3")
    @ResponseBody
    public MyDto34Customer method3(){
        return dao.getCustomer();
    }


    // /api/main1/sub4?id=33
    @GetMapping("sub4")
    @ResponseBody
    public ResponseEntity<MyDto34Customer> method4(Integer id){
        MyDto34Customer customer = dao.getCustomerById(id);
        if(customer==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("sub5")
    @ResponseBody
    public Map<String, Object> method5(Integer id){
        MyDto33Employee employee = dao.getEmployeeById(id);
        List<Integer> employeelist = dao.getEmployeeList();
        Map<String, Object> map;
        if(employee==null){
            map = Map.of("responseEntity", ResponseEntity.notFound().build(), "employeeList", employeelist);
        }else{
            map = Map.of("responseEntity", ResponseEntity.ok(employee), "employeeList", employeelist);
        }
        return map;
    }
//    public ResponseEntity<MyDto33Employee> method5(Integer id){
//        MyDto33Employee employee = dao.getEmployeeById(id);
//        if(employee==null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(employee);
//    }

    @GetMapping("sub6")
    @ResponseBody
    public List<Integer> method6(){
        return dao.getCustomerIdList();
    }
}
