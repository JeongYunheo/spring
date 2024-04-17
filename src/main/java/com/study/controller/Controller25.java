package com.study.controller;

import com.study.domain.*;
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
@RequestMapping("main25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void sub1(@RequestParam(value = "name", required = false) String searchName, Model model) throws SQLException {
        var list = new ArrayList<MyBean251>();

        String sql = STR."""
                SELECT *
                FROM Employees
                WHERE LastName = '\{searchName}'
                """;
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (conn; stmt; rs) {
            while (rs.next()) {
                String id = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String birthDate = rs.getString(4);
                String photo = rs.getString(5);
                String notes = rs.getString(6);

                MyBean251 obj =
                        new MyBean251(id, lastName, firstName, birthDate, photo, notes);
                list.add(obj);
            }
        }
        model.addAttribute("employees", list);

    }

    @GetMapping("sub2")
    public void sub2(@RequestParam(value = "name", required = false) String search, Model model) throws SQLException {
        // name 요청 파라미터와 일치하는 상품명으로 상품(products) 조회
        // 예) SELECT * FROM Products WHERE ProductName = 'chais'
        var list = new ArrayList<MyBean252>();

        String sql = STR."""
                SELECT * FROM Products
                WHERE ProductName = '\{search}'
                """;

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try (conn; stmt; rs) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String unit = rs.getString(5);
                double price = rs.getDouble(6);

                MyBean252 obj = new MyBean252(id, name, unit, price);
                list.add(obj);
            }
        }
        model.addAttribute("products", list);
    }

    @GetMapping("sub3")
    public void sub3(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean252>();
        String oldsql = STR."""
                SELECT * FROM Products
                WHERE ProductName = '\{search}'
                """;
        String sql = """
                SELECT * FROM Products
                WHERE ProductName = ?
                """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 첫번째 파라미터: 물음표 위치
        // 두번째 파라미터: 넣을 값
        pstmt.setString(1, search);

        ResultSet rs = pstmt.executeQuery();

        try (conn; pstmt; rs) {
            while (rs.next()) {
                MyBean252 row = new MyBean252(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(5),
                        rs.getDouble(6));

                list.add(row);
            }
        }

        model.addAttribute("products", list);
    }

    // 고객 이름 입력 받아서 고객 정보 조회
    // sub4 메소드와 sub4.jsp 작성
    @GetMapping("sub4")
    public String sub4(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean254Customer>();
        String oldsql = STR."""
                SELECT * FROM Products
                WHERE ProductName = '\{search}'
                """;

        String sql = """
                SElECT * FROM Customers
                WHERE CustomerName = ?
                """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, search);
        ResultSet rs = pstmt.executeQuery();

        try (conn; pstmt; rs) {
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

        }

        model.addAttribute("customers", list);
        model.addAttribute("prevSearch", search);
        return "main25/sub4CustomerList";

    }

    @GetMapping("sub5")
    public String sub5(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean254Customer>();
        String sql = """
                SELECT * FROM Customers
                WHERE CustomerName LIKE ?
                """;
        String keyword = "%" + search + "%";

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, keyword);
        ResultSet rs = pstmt.executeQuery();

        try (conn; pstmt; rs) {
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

        }
        model.addAttribute("customers", list);
        model.addAttribute("prevSearch", search);
        return "main25/sub4CustomerList";
    }

    // 상품명으로 상품들 조회 메소드 작성
    @GetMapping("sub6")
    public String sub6(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean256Product>();

        String sql = """
                SELECT * FROM Products
                WHERE Productname LIKE ?
                """;
        String keyword = "%" + search + "%";

        Connection cnn = dataSource.getConnection();
        PreparedStatement pstmt = cnn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        ResultSet rs = pstmt.executeQuery();

        try (cnn; pstmt; rs) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String supplier = rs.getString(3);
                String category = rs.getString(4);
                String unit = rs.getString(5);
                String price = rs.getString(6);


                MyBean256Product obj = new MyBean256Product(id, name, supplier, category, unit, price);
                list.add(obj);
            }
        }

        model.addAttribute("products", list);
        return "main25/sub6ProductList";
    }

    // 조회 문자열이 contactName customerName에 포함된 고객들 조회
    @GetMapping("sub7")
    public String sub7(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean254Customer>();
        String sql = """
                SELECT * FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                """;
        String keyword = "%" + search + "%";
        Connection cnn = dataSource.getConnection();
        PreparedStatement pstmt = cnn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        pstmt.setString(2, keyword);
        ResultSet rs = pstmt.executeQuery();

        try (cnn; pstmt; rs) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String contactName = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String postalCode = rs.getString(6);
                String country = rs.getString(7);

                MyBean254Customer obj = new MyBean254Customer(id, name, contactName, address, city, postalCode, country);
            }
        }
        model.addAttribute("customers", list);
        model.addAttribute("prevSearch", search);
        return "main25/sub4CustomerList";
    }

    // 조회 문자열이 last name 혹은 first name에 포함된 직원들 조회 메소드

    @GetMapping("sub8")
    public String sub8(Model model, String search) throws SQLException {
        var list = new ArrayList<MyBean258Employees>();

        String sql = """
                SELECT * FROM Employees
                WHERE FirstName LIKE ?
                OR LastName LIKE ?
                """;
        String keyword = "%" + search + "%";
        Connection cnn = dataSource.getConnection();
        PreparedStatement pstmt = cnn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        pstmt.setString(2, keyword);
        ResultSet rs = pstmt.executeQuery();

        try (cnn; pstmt; rs) {
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
        }
        model.addAttribute("employees", list);
        model.addAttribute("prevSearch", keyword);
        return "main25/sub8EmployeeList";
    }
}
