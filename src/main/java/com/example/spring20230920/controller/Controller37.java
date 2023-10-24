package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto41;
import com.example.spring20230920.domain.MyDto42;
import com.example.spring20230920.domain.MyDto43;
import com.example.spring20230920.domain.MyDto44;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("main37")
@RequiredArgsConstructor
public class Controller37 {

    private final MyDao7 dao;
    /*
    axios.post("/main37/sub1", '{"name":"jones"}', {
        headers:{
            "content-type":"application/json"
        }
        })
     */
    // 직렬화(serialize): js(java) Object -> json text
    // 파싱(parse): json text -> js(java) object
    @PostMapping("sub1")
    public void method1(@RequestBody Map<String, Object> map){
        System.out.println("map = " + map);
    }

    /*
    axios.post("/main37/sub2", {name:"lee", age:33, score: 8.9})
     */
    /*
    js object
    {name:"lee", age:33, score: 8.9}
    ->직렬화
    json text
    '{"name":"lee", "age":33, "score": 8.9}'
    ->파싱
    java map
    {name="lee", age=33, score= 8.9}
     */
    @PostMapping("sub2")
    public void method2(@RequestBody Map<String, Object> map){
        System.out.println("map = " + map);
    }
     /*
    axios.put("/main37/sub3", {
        city: "seoul",
        name: "son",
        email: "son@gmail.com"
    })
     */

    @PutMapping("sub3")
    public void method3(@RequestBody Map<String, Object> map){
        System.out.println("map = " + map);
    }

    /*
    axios.post("/main37/sub4", {city: "paris", age: 30, married: true,
                                car: null, home:{address:"seoul", price:1000},
                                foods: ["pizza", "burger"]
                                })
     */
    @PostMapping("sub4")
    public void method4(@RequestBody MyDto42 dto){
        System.out.println("dto = " + dto);
    }


    @PostMapping("sub5")
    public void method5(@RequestBody MyDto43 dto){
        System.out.println("dto.getCountry() = " + dto.getCountry());
        System.out.println("dto.getScore() = " + dto.getScore());
        System.out.println("dto.getSkills() = " + dto.getSkills());
        System.out.println("dto.getPhone() = " + dto.getPhone());
    }

    /*
    axios.post("/main37/sub6", {
        name: "son",
        email: ["son@gmail.com", "hm@gmail.com"],
        home: {
            first: "seoul",
            second: "london"
        },
        price: 35.11,
        weight: 77.6,
        married: true
    })

     */
    @PostMapping("sub6")
    public void method6(@RequestBody MyDto44 dto){
        System.out.println("dto.getName() = " + dto.getName());
        System.out.println("dto.getEmail() = " + dto.getEmail());
        System.out.println("dto.getHome() = " + dto.getHome());
        System.out.println("dto.getPrice() = " + dto.getPrice());
        System.out.println("dto.getWeight() = " + dto.getWeight());
        System.out.println("dto.getMarried() = " + dto.getMarried());
    }

    /*
    axios.put("/main37/sub7", {
        id: 3,
        lastName: "kim",
        firstName: "minjae",
        birthDate: "1999-09-09"
        })
     */
    @PutMapping("sub7")
    public void method7(@RequestBody MyDto41 dto){
        dao.updateEmployee(dto);
        System.out.println(dto.getId()+"번 직원 수정됨");
    }
}
