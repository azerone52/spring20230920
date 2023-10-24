package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("main36")
@RequiredArgsConstructor
public class Controller36 {

    private final MyDao7 dao;

    @GetMapping("sub1")
    public void method1(){

    }
    // axios.get("/main36/sub2", {params: {id: 5}})
    // /main36/sub2?id=5
    @GetMapping("sub2")
    public void method2(Integer id){
        Map<String, Objects> data = dao.selectByCustomId(id);
        System.out.println("data = " + data);
    }

    // axios.get("/main35/sub3", {params: {id: 2}})
    // /main36/sub3?id=2
    @GetMapping("sub3")
    public void method3(Integer id){
        Map<String, Objects> data = dao.selectByEmployeeId(id);
        System.out.println("data = " + data);
    }

    // axios.post("/main36/sub4", {lastName:"손", firstName:"흥민", birthDate:"2020-02-02"},
    //              {headers: {"content-type" : "application/x-www-form-urlencoded"}})
    // post /main36/sub4
    // lastName=손&firstName=흥민&birthDate=2020-02-02
    @PostMapping("sub4")
    public void method4(String lastName, String firstName, LocalDate birthDate){
        int i = dao.insertEmployee(lastName, firstName, birthDate);
        System.out.println("i = " + i);
    }

    /*
        axios.post("/main36/sub5",
                    {name: "라면", price: 15.00, category: 3},
                     {headers: {"content-type" : "application/x-www-form-urlencoded"}}
                     );
    */
    // post /main36/sub5
    // name=라면&price=150.00&category=3
    @PostMapping("sub5")
    public void method5(String name, Double price, Integer category){
        int r = dao.insertProduct(name, price, category);
        System.out.println("r = " + r);
    }

    //axios.delete("/main36/sub6")
//    @RequestMapping(method = RequestMethod.DELETE, value = "sub6")
    @DeleteMapping("sub6")
    public void method6(){
        System.out.println("Controller36.method6");
    }

    // axios.delete("/main36/sub7");
    @DeleteMapping("sub7")
    public void method7(){
        System.out.println("Controller36.method7");
    }

    /*
    axios.delete("/main36/sub8?name=son")
    axios.delete("/main36/sub8", {
           params: {id:"son"}
           });
    */
    @DeleteMapping("sub8")
    public void method8(String name){
        System.out.println("name = " + name);
    }

    // PathVariable : 경로에 포함된 데이터
    /*
    axios.delete("/main36/sub9/son")
     */
    @DeleteMapping("sub9/{name}")
    public void method9(@PathVariable("name") String n){
        System.out.println("n = " + n);
    }

    /*
    axios.delete("/main36/sub10/3")
    axios.delete("/main36/sub10/5")
     */
    @DeleteMapping("sub10/{num}")
    public void method10(@PathVariable Integer num){
        // 같으면 생략 가능
        System.out.println("num = " + num);
    }

    // axios.delete("/main36/sub11/")
    @DeleteMapping("sub11/{pid}")
    public void method11(@PathVariable Integer pid){
        int c = dao.deleteByProductId(pid);
        System.out.println("c = " + c);
    }
    // axios.delete("/main36/sub12/1")
    @DeleteMapping("sub12/{cid}")
    public void method12(@PathVariable Integer cid){
        int r = dao.deleteByCustomerId(cid);
        System.out.println("r = " + r);
    }

    /*
    axios.put("/main36/sub13")
    put /main36/sub13
     */
//    @RequestMapping(method=RequestMethod.PUT, value="sub13")
    @PutMapping("sub13")
    public void method13(){
        System.out.println("Controller36.method13");
    }

    /*
    axios.put("/main36/sub14", {
               name:"son",
               address:"korea"
               },{
                headers: {
                 "content-type" : "application/x-www-form-urlencoded"
                }
                })
     */
    @PutMapping("sub14")
    public void method14(String name, String address){
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    /*
        axios.put("/main36/sub15", {
        city: "seoul",
        age: 78,
        score: 3.14
    }, {
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    });
     */
    @PutMapping("sub15")
    public void method15(String city, Integer age, Double score){
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
    }

    /*
    axios.put("/main36/sub16", {
        id: 3,
        name: "햄버거",
        category: 2,
        price: 5000.00
        }, {
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    });
     */
    @PutMapping("sub16")
    public void method16(MyDto40 dto){
        int rows = dao.updateProduct(dto);
        System.out.println(rows+"개 데이터 수정됨");
    }

    /*
    axios.put("/main36/sub17", {
        lastName: "lee",
        firstName: "kangin",
        birthDate: "2020-01-01",
        id: 5
        }, {
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    });
     */
    @PutMapping("sub17")
    public void method17(MyDto41 dto){
        int row = dao.updateEmployee(dto);
        System.out.println("row = " + row);
        System.out.println("lastName = " + dto.getLastName());
        System.out.println("firstName = " + dto.getFirstName());
    }
}
