package com.example.spring20230920.domain;

import lombok.Data;

@Data
public class MyDto19 {
    // sql에서 사용할 것이므로 변수명의 대소문자 구분 하지 않음
    private Integer employeeID;
    private String lastName;
    private String firstName;
}
