package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
@RequestMapping("main23")
public class Controller23 {
    @RequestMapping("sub1")
    public void method1(Model model) throws Exception {
        var list = new ArrayList<String>();

        // 요청 파라미터 분석/가공
        // 비지니스 로직 실행
        String sql = """
                SELECT FirstName FROM Employees
                """;
        // 1. db와 연결
        String url = "jdbc:mariadb://localhost:3306/w3schools";
        String user = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, user, password);
        // 2. 실행 준비
        Statement statement = con.createStatement();
        // 3. 쿼리 실행
        ResultSet resultSet = statement.executeQuery(sql);

        try (resultSet; statement; con) {
            // 4. 결과 가공
            while (resultSet.next()) {
                String name = resultSet.getString(1); // 첫번째 컬럼에 있는 값
                list.add(name);
            }
        }

        // 5. 자원 닫기


        // 모델에 결과 넣고
        model.addAttribute("nameList", list);
        // view로 포워드
    }

    @RequestMapping("sub2")
    public void method2(Model model) throws Exception {
        var list = new ArrayList<String>();

        String sql = """
                SELECT CustomerName FROM Customers
                """;

        // 1. db 연결
        String url = "jdbc:mariadb://localhost:3306/w3schools";
        String user = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, user, password);
        // 2. 실행 준비
        Statement statement = con.createStatement();
        // 3. 쿼리 실행
        ResultSet resultSet = statement.executeQuery(sql);
        // 5. 자원 닫기(try with resource)
        try (resultSet; statement; con) {
            // 4. 결과 가공
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                list.add(name);
            }
        }
        // 6. 모델에 attribute 결과 넣기
        model.addAttribute("nameList", list);
        // 7. view로 forward

        // jsp > 91명 고객 이름 출력
    }
}
