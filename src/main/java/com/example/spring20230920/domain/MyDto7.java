package com.example.spring20230920.domain;

public class MyDto7 {
    public String getName(){
        return "김광식";
    }
    public String getEmail(){
        return "abc@google.com";
    }
    public Integer getAge(){
        return 24;
    }
    @Override
    public String toString() {
        return "내가 만든 클래스😊";
    }
}
