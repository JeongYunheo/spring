package com.study.controller;

import com.study.domain.MyBean254Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(Integer page, Model model) throws SQLException {
        int offset = (page - 1) * 10;
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, 10
                """;
        var list = new ArrayList<MyBean254Customer>();

        Connection conn = dataSource.getConnection();
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
}
