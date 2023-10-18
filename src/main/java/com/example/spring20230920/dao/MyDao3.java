package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao3 {

    // 1행 1열 쿼리
    @Select("""
    SELECT CustomerName FROM customers
    WHERE CustomerID = 1
    """)
    String select1();

    @Select("""
    SELECT price FROM products
    WHERE ProductID = 1
    """)
    Double select2();

    @Select("""
    SELECT LastName FROM employees
    WHERE EmployeeID = 1
    """)
    String select3();

    @Select("""
    SELECT BirthDate FROM employees
    WHERE EmployeeID = 2
    """)
    LocalDate select4();

    @Select("""
    SELECT DISTINCT Country FROM customers
    ORDER BY 1
    """)
    List<String> select5();

    @Select("""
    SELECT BirthDate FROM employees
    """)
    List<LocalDate> select6();

    @Select("""
    SELECT ProductName, Price FROM products
    """)
    List<Map<String, Double>> select7();

    @Select("""
    SELECT CustomerID, CustomerName, Address 
    FROM customers
    WHERE CustomerID = 1
    """)
    Map<String, Object> select8();

    @Select("""
    SELECT ProductName, Price, CategoryName
    FROM products JOIN categories ON products.CategoryID = categories.CategoryID
    WHERE ProductID = 1 
    """)
    Map<String, Object> select9();

    @Select("""
    SELECT EmployeeID ,LastName, FirstName 
    FROM employees
    WHERE EmployeeID = 1
    """)
    MyDto19 select10();

    @Select("""
    SELECT ProductName name, Price, CategoryName category
    FROM products JOIN categories ON products.CategoryID = categories.CategoryID
    WHERE ProductID = 1
    """)
    MyDto20 select11();

    @Select("""
    SELECT CustomerID id, CustomerName name, Country
    FROM customers
    WHERE CustomerID = 2
    """)
    MyDto21 slect12();

    @Select("""
    SELECT ProductID id, ProductName name, Price
    FROM products
    WHERE CategoryID = 2
    """)
    List<Map<String, Object>> select13();

    @Select("""
    SELECT ProductName, Quantity, Price
    FROM products JOIN orderdetails ON products.ProductID = orderdetails.ProductID
                  JOIN orders ON orders.OrderID = orderdetails.OrderID
    WHERE OrderDate = '1996-07-04'
    """)
    List<Map<String, Object>> select14();

    @Select("""
    SELECT ProductName, Quantity, Price
    FROM products JOIN orderdetails ON products.ProductID = orderdetails.ProductID
                  JOIN orders ON orders.OrderID = orderdetails.OrderID
    WHERE OrderDate = '1996-07-04'
    """)
    List<MyDto22> select15();

    @Select("""
    SELECT OrderDate, ProductName, CategoryName, Quantity, Price
    FROM orders JOIN orderdetails ON orders.OrderID = orderdetails.OrderID
                JOIN products ON products.ProductID = orderdetails.ProductID
                JOIN categories ON products.CategoryID = categories.CategoryID
    WHERE categories.CategoryID = 1
    ORDER BY OrderDate, ProductName
    """)
    List<Map<String, Object>> select16();

    @Select("""
    SELECT CustomerName
    FROM customers
    WHERE CustomerID = 100
    """)
    String select17();

    @Select("""
    SELECT CustomerID
    FROM customers
    WHERE CustomerID = 100
    """)
    Integer select18();

    @Select("""
    SELECT CustomerId id, CustomerName name, Country
    FROM customers
    WHERE CustomerID = 1
    """)
    MyDto24 select19();

    @Select("""
    SELECT CustomerId id, CustomerName name, Country
    FROM customers
    WHERE CustomerID > 1
    """)
    MyDto24 select20();
}
