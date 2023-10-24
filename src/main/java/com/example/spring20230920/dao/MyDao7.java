package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao7 {

    @Select("""
    SELECT * FROM customers
    WHERE CustomerID = #{id}
    """)
    Map<String, Objects> selectByCustomId(Integer id);

    @Select("""
    SELECT * FROM employees
    WHERE EmployeeID = #{id}
    """)
    Map<String, Objects> selectByEmployeeId(Integer id);

    @Insert("""
    INSERT INTO employees (lastname, firstname, birthdate)
    VALUE (#{lastName}, #{firstName}, #{birthDate})
    """)
    int insertEmployee(String lastName, String firstName, LocalDate birthDate);

    @Insert("""
    INSERT INTO products (ProductName, CategoryID, Price)
    VALUE (#{name}, #{category}, #{price})
    """)
    int insertProduct(String name, Double price, Integer category);

    @Delete("""
    DELETE FROM products
    WHERE ProductID = #{pid}
    """)
    int deleteByProductId(Integer pid);

    @Delete("""
    DELETE FROM customers 
    WHERE CustomerID = #{cid}
    """)
    int deleteByCustomerId(Integer cid);

    @Update("""
    UPDATE products 
    SET price = #{price}, 
        CategoryID = #{category},
        ProductName = #{name}
    WHERE ProductID = #{id}
    """)
    int updateProduct(MyDto40 dto);

    @Update("""
    UPDATE employees 
    SET LastName = #{lastName},
        FirstName = #{firstName},
        BirthDate = #{birthDate}
    WHERE EmployeeID = #{id}
    """)
    int updateEmployee(MyDto41 dto);
}
