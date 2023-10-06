package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main22")
public class Controller22 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Integer page) throws SQLException {
        String sql = """
                SELECT customerId id, customerName name
                FROM customers
                ORDER BY id
                LIMIT ?,?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, 0);//1페이지
        statement.setInt(1, (page-1)*10);
        statement.setInt(2, 10);
        ResultSet resultSet = statement.executeQuery();

        try(connection;statement;resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");

                System.out.println(id + " : "+name);
            }
        }

    }
    // 페이지 당 7개 씩 공급자 목록 조회
    // /main22/sub2?p=2
    @GetMapping("sub2")
    public void method2(Model model) throws SQLException {
        String sql = """
                SELECT SupplierID, SupplierName
                FROM suppliers
                ORDER BY SupplierID
                LIMIT 7;
                """;

        String sql2 = "SELECT COUNT(*) FROM suppliers";

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ResultSet rs = statement.executeQuery(sql2);

        List<Map<String, String>> list = new ArrayList<>();
        int cnt = 0;
        try(connection; statement; resultSet; rs){
            while (resultSet.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("SupplierId"));
                map.put("name", resultSet.getString("SupplierName"));

                list.add(map);
            }
            rs.next();
            cnt = rs.getInt(1);
        }
        if(cnt%7!=0){
            cnt /= 7;
            cnt++;
        }else{
            cnt /= 7;
        }
        model.addAttribute("suppliers", list);
        model.addAttribute("cnt", cnt);
    }
    @GetMapping(value = "sub2", params = "p")
    public void method2(@RequestParam("p") Integer page, Model model) throws SQLException {
        String sql = """
                SELECT SupplierID, SupplierName
                FROM suppliers
                ORDER BY SupplierID
                LIMIT ?,7;
                """;

        String sql2 = "SELECT COUNT(*) FROM suppliers";

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,(page-1)*7);
        ResultSet resultSet = statement.executeQuery();

        Statement statement1 = connection.createStatement();
        ResultSet rs = statement1.executeQuery(sql2);

        List<Map<String, String>> list = new ArrayList<>();
        int cnt = 0;
        try(connection; statement; resultSet; rs){
            while (resultSet.next()){
                Map<String, String> map = new HashMap<>();
                map.put("id", resultSet.getString("SupplierId"));
                map.put("name", resultSet.getString("SupplierName"));

                list.add(map);
            }
            rs.next();
            cnt = rs.getInt(1);
        }
        if(cnt%7!=0){
            cnt /= 7;
            cnt++;
        }else{
            cnt /= 7;
        }
        model.addAttribute("suppliers", list);
        model.addAttribute("cnt", cnt);
    }
}
