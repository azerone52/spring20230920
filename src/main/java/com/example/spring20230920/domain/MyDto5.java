package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//모든 필드를 생성자로 갖는 생성자 만들어줌
@AllArgsConstructor
//파라미터 없는 생성자 만들어줌
@NoArgsConstructor
//final 필드에 대한 생성자 만들어줌
//@RequiredArgsConstructor
public class MyDto5 {
    private String name;
    private Integer age;

}
