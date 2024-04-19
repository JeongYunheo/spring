package com.study.controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean258Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("main28")
public class Controller28 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void sub1() {

    }

    @PostMapping("sub1")
    public String sub2(MyBean254Customer customer, RedirectAttributes rttr) throws SQLException {
        System.out.println("customer = " + customer);
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        try (pstmt; conn) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getAddress());
            pstmt.setString(4, customer.getCity());
            pstmt.setString(5, customer.getPostalCode());
            pstmt.setString(6, customer.getCountryName());

            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", "새 고객이 등록되었습니다");
            }
        }
        return "redirect:/main28/sub1";
    }

    // 새 직원 입력하기
    @GetMapping("sub3")
    public void sub3() {
    }

    @PostMapping("sub3")
    public String sub4(MyBean258Employees employees, RedirectAttributes rttr) throws SQLException {
        String sql = """
                INSERT INTO Employees 
                (LastName,FirstName,BirthDate,Photo,Notes)
                VALUES (?, ?, ?, ?, ?)
                """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try (pstmt; conn) {
            pstmt.setString(1, employees.getLastName());
            pstmt.setString(2, employees.getFirstName());
            pstmt.setString(3, employees.getBirth());
            pstmt.setString(4, employees.getPhoto());
            pstmt.setString(5, employees.getNote());

            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", "직원 등록이 완료되었습니다");
            }
        }
        return "redirect:/main28/sub3";
    }
}
