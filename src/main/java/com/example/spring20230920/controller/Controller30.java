package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main30")
public class Controller30 {
    private final MyDao4 dao;

}
