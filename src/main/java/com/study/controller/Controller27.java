package com.study.controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean258Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1") Integer page,
                       Model model) throws SQLException {
        if (page == null) {
            page = 1;
        }
        int offset = (page - 1) * 10;
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, 10
                """;
        var list = new ArrayList<MyBean254Customer>();

        Connection conn = dataSource.getConnection();

        //페이지 정보 산출
        // 총 레토드 수 조회
        String countSql = "SELECT COUNT(*) FROM Customers";
        Statement stmt = conn.createStatement();
        ResultSet rs1 = stmt.executeQuery(countSql);
        int total = 0;
        try (rs1; stmt) {
            if (rs1.next()) {
                total = rs1.getInt(1);
            }
        }

        // 마지막 페이지 번호
        int lastPageNumber = (total - 1) / 10 + 1;
        model.addAttribute("lastPageNumber", lastPageNumber);

        // 페이지 링크의 begin, end 산출
        int endPageNumber = ((page - 1) / 10 + 1) * 10;
        int beginPageNumber = endPageNumber - 9;

        // endPageNumber가 최종페이지 넘을 순 없다
        endPageNumber = Math.min(endPageNumber, lastPageNumber);

        model.addAttribute("endPageNumber", endPageNumber);
        model.addAttribute("beginPageNumber", beginPageNumber);

        // 다음 버튼 클릭 시 이도해야 하는 페이지 nextPageNumber 산출
        int nextPageNumber = (beginPageNumber + 10);
        if (nextPageNumber <= lastPageNumber) {
            model.addAttribute("nextPageNumber", nextPageNumber);
        }

        // 이전 버튼 클릭 시 이동해야 하는 페이지 prevPageNumber 산출
        int prevPageNumber = beginPageNumber - 10;
        if (prevPageNumber >= 1) {
            model.addAttribute("prevPageNumber", prevPageNumber);
        }

        //현재 페이지
        model.addAttribute("currentPage", page);

        //고객 레코드 조회
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, offset);
        ResultSet rs = pstmt.executeQuery();

        try (rs; pstmt; conn) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String contactName = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String postalCode = rs.getString(6);
                String country = rs.getString(7);

                MyBean254Customer obj = new MyBean254Customer(id, name, contactName, address, city, postalCode, country);

                list.add(obj);
            }
            model.addAttribute("customerList", list);
        }
        return "main27/sub1";
    }

    @GetMapping("sub2")
    public String sub2(@RequestParam(defaultValue = "1") Integer page, Model model) throws SQLException {

        int offSet = (page - 1) * 10;
        String sql = """
                SELECT *
                FROM Employees
                ORDER BY EmployeeID
                LIMIT ?, 10
                """;

        Connection conn = dataSource.getConnection();

        //페이지 정보 산출
        // 총 레코드 수 조회
        String countSql = "SELECT COUNT(*) FROM Employees";
        Statement stmt = conn.createStatement();
        ResultSet rs1 = stmt.executeQuery(countSql);
        int total = 0;
        try (rs1; stmt) {
            if (rs1.next()) {
                total = rs1.getInt(1);
            }
        }

        // 마지막 페이지 번호
        int lastPageNumber = (total - 1) / 10 + 1;
        model.addAttribute("lastPageNumber", lastPageNumber);

        // 페이지 링크의 begin, end 산출
        int endPageNumber = ((page - 1) / 10 + 1) * 10;
        int beginPageNumber = endPageNumber - 9;

        // endPageNumber가 최종페이지 넘을 순 없다
        endPageNumber = Math.min(endPageNumber, lastPageNumber);
        model.addAttribute("endPageNumber", endPageNumber);
        model.addAttribute("beginPageNumber", beginPageNumber);

        // 다음 버튼 클릭 시 이동해야 하는 페이지 nextPageNumber 산출
        int nextPageNumber = (beginPageNumber + 10);
        if (nextPageNumber <= lastPageNumber) {
            model.addAttribute("nextPageNumber", nextPageNumber);
        }

        // 이전 버튼 클릭 시 이동해야 하는 페이지 prevPageNumber 산출
        int prevPageNumber = beginPageNumber - 10;
        if (prevPageNumber >= 1) {
            model.addAttribute("prevPageNumber", prevPageNumber);
        }

        // 현재 페이지
        model.addAttribute("currentPage", page);

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, offSet);
        ResultSet rs = pstmt.executeQuery();

        var list = new ArrayList<MyBean258Employees>();

        try (rs; pstmt; conn) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String birthdate = rs.getString(4);
                String photo = rs.getString(5);
                String note = rs.getString(6);

                MyBean258Employees obj = new MyBean258Employees(id, firstname, lastname, birthdate, photo, note);
                list.add(obj);
            }
            model.addAttribute("employees", list);
        }

        return "main27/sub2";
    }
}
