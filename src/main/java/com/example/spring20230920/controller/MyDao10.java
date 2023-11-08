package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.List;

@Mapper
public interface MyDao10 {
    @Select("""
    SELECT CustomerName FROM customers
    WHERE CustomerID = #{id}
    """)
    String select(Integer id);

    @Select("""
    SELECT * FROM customers
    WHERE CustomerID=50
    """)
    MyDto34Customer getCustomer();

    @Select("""
    SELECT * FROM customers
    WHERE CustomerID = #{id}
    """)
    MyDto34Customer getCustomerById(Integer id);

    @Select("""
    SELECT * FROM employees
    WHERE EmployeeID = #{id}
    """)
    MyDto33Employee getEmployeeById(Integer id);

    @Select("""
    SELECT customerId FROM customers ORDER BY CustomerID
    """)
    List<Integer> getCustomerIdList();

    @Select("""
    SELECT EmployeeID FROM employees ORDER BY EmployeeID
    """)
    List<Integer> getEmployeeList();
}
