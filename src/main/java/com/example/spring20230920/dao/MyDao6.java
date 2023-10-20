package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao6 {
    @Insert("""
    INSERT INTO customers (CustomerName)
    VALUE (#{name})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert1(MyDto37 dto);

    @Insert("""
    INSERT INTO employees (LastName)
    VALUE (#{lastName})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert2(MyDto38 dto);

    @Insert("""
    INSERT INTO employees (lastName, FirstName)
    VALUE (#{lastName}, #{firstName})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert3(MyDto38 dto);

    @Update("""
    UPDATE bank
    SET money = money - 1000
    WHERE name = 'son'
    """)
    int update1();

    @Update("""
    UPDATE bank
    SET money = money + 1000
    WHERE name = 'kim'
    """)
    int update2();

    @Select("""
    SELECT * FROM bank
    ORDER BY name
    """)
    List<Map<String, Objects>> select3();
}
