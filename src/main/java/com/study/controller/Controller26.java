package com.study.controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean256Product;
import com.study.domain.MyBean261Orders;
import com.study.domain.MyBean263Category;
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
@RequestMapping("main26")
public class Controller26 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(Model model, String start, String end) throws SQLException {
        var list = new ArrayList<MyBean261Orders>();
        String sql = """
                SELECT *
                FROM Orders
                WHERE OrderDate BETWEEN ? AND ?
                """;
        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, start);
        pstmt.setString(2, end);
        ResultSet rs = pstmt.executeQuery();

        try (con; pstmt; rs) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer = rs.getString(2);
                String employee = rs.getString(3);
                String date = rs.getString(4);
                String ship = rs.getString(5);

                MyBean261Orders obj = new MyBean261Orders(id, customer, employee, date, ship);
                list.add(obj);
            }
        }
        model.addAttribute("orderList", list);
        model.addAttribute("prevStart", start);
        model.addAttribute("prevEnd", end);
        return "main26/sub1OrderList";
    }

    @GetMapping("sub2")
    public String sub2(String[] country, Model model) throws SQLException {
        Connection con = dataSource.getConnection();

        if (country != null && country.length > 0) {
            String questionMark = "";
            for (int i = 0; i < country.length; i++) {
                questionMark = questionMark + "?";
                if (i != country.length - 1) {
                    questionMark = questionMark + ",";
                }
            }
            String customerSql = STR."""
                SELECT *
                FROM Customers
                WHERE Country IN(\{questionMark})
                """;
            var customerList = new ArrayList<MyBean254Customer>();
            PreparedStatement pstmt = con.prepareStatement(customerSql);
            for (int i = 0; i < country.length; i++) {
                pstmt.setString((i + 1), country[i]);
            }
            ResultSet resultSet = pstmt.executeQuery();
            try (pstmt; resultSet) {
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String contactName = resultSet.getString(3);
                    String address = resultSet.getString(4);
                    String city = resultSet.getString(5);
                    String postalCode = resultSet.getString(6);
                    String countryName = resultSet.getString(7);

                    MyBean254Customer data = new MyBean254Customer(id, name, contactName, address, city, postalCode, countryName);
                    customerList.add(data);
                }
                model.addAttribute("customers", customerList);
            }
        }

        String sql = """
                SELECT DISTINCT Country
                FROM Customers
                """;

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        var countryList = new ArrayList<String>();
        try (stmt; rs; con) {
            while (rs.next()) {
                countryList.add(rs.getString(1));
            }
            model.addAttribute("countryList", countryList);
        }

        return "main25/sub4CustomerList";
    }

    @GetMapping("sub3")
    public String sub3(@RequestParam(value = "category", required = false) int[] categorySelect,
                       Model model) throws SQLException {
        Connection con = dataSource.getConnection();
        if (categorySelect != null && categorySelect.length > 0) {
            String questionMark = "";
            for (int i = 0; i < categorySelect.length; i++) {
                questionMark = questionMark + "?";
                if (i != categorySelect.length - 1) {
                    questionMark = questionMark + ",";
                }
            }
            String sql = STR."""
                    SELECT *
                    FROM Products
                    WHERE CategoryID IN (\{questionMark})
                    ORDER BY CategoryID, Price
                    """;
            var productList = new ArrayList<MyBean256Product>();
            PreparedStatement pstmt = con.prepareStatement(sql);
            for (int i = 0; i < categorySelect.length; i++) {
                pstmt.setInt((i + 1), categorySelect[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            try (pstmt; rs) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String supplier = rs.getString(3);
                    String category = rs.getString(4);
                    String unit = rs.getString(5);
                    String price = rs.getString(6);

                    MyBean256Product obj = new MyBean256Product(id, name, supplier, category, unit, price);
                    productList.add(obj);
                }
                model.addAttribute("prevCategorySelect", categorySelect);
                model.addAttribute("products", productList);
            }
        }


        String categorySql = "SELECT * FROM Categories";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(categorySql);
        var categoryList = new ArrayList<MyBean263Category>();
        try (con; stmt; rs) {
            while (rs.next()) {
                MyBean263Category category = new MyBean263Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));

                categoryList.add(category);
            }
            model.addAttribute("categoryList", categoryList);
        }
        return "main25/sub6ProductList";
    }
}
