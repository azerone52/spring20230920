package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// 붙인 인터페이스로 클래스를 만들고 그 클래스에 컴포넌트도 붙여줌
@Mapper
public interface MyDao2 {
    @Select("""
    SELECT LastName FROM employees
    WHERE EmployeeID = #{id}
    """)
    String select(Integer id);
}
