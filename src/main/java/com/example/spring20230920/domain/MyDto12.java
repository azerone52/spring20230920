package com.example.spring20230920.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MyDto12 {
    private Integer id;
    private String name;
    private String address;
    private LocalDate schedule;
    private List<String> todos;
}
