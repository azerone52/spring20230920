package com.example.spring20230920.domain;

public class MyDto1 {
    //property 명: get/set 없애고 소문자로 시작
    //대문자 연속이면 그냥 대문자로 시작

    //name property
    //homeAddress property
    //MYHOME property

    private String name;
    private String homeAddress;
    private String MYHOME;
    private Boolean married;
    private boolean checked;

    //boolean 타입은 is도 get도 괜찮음
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getMYHOME() {
        return MYHOME;
    }

    public void setMYHOME(String MYHOME) {
        this.MYHOME = MYHOME;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }
}
