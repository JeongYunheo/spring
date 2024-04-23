package com.study.controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean258Employees;
import com.study.mapper.Mapper01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// @Component
@Controller
@RequestMapping("main30")
public class Controller30 {
    @Autowired
    private DataSource dataSource;

    // 직접 만든 객체(dependency)
//      private Mapper01 mapper = new Mapper01();

    // Dependency Injection (DI)
    // Inversion Of Control (IOC)
    // 자동으로 객체 만들어짐
    @Autowired
    private Mapper01 mapper;


    @GetMapping("sub1")
    public void sub1(Integer id, Model model) throws SQLException {
        MyBean254Customer c = mapper.getCustomerByID(id);
        model.addAttribute("customer", c);
    }

    @PostMapping("sub1/update")
    public String update1(MyBean254Customer customer, RedirectAttributes rttr) throws SQLException {

        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address= ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                    WHERE CustomerID = ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try (conn; pstmt;) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getAddress());
            pstmt.setString(4, customer.getCity());
            pstmt.setString(5, customer.getPostalCode());
            pstmt.setString(6, customer.getCountryName());
            pstmt.setInt(7, customer.getId());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                rttr.addFlashAttribute("message", customer.getId() + " has been updated");
            } else {
                rttr.addFlashAttribute("message", customer.getId() + " has not been updated");
            }

        }
        rttr.addAttribute("id", customer.getId());
        return "redirect:/main30/sub1";
    }

    // 직원 조회 및 수정
    @GetMapping("sub2")
    public void sub2(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Employees
                    WHERE EmployeeID = ?
                    """;

            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            try (conn; pstmt; rs) {
                while (rs.next()) {
                    MyBean258Employees e = new MyBean258Employees();

                    e.setId(rs.getInt(1));
                    e.setLastName(rs.getString(2));
                    e.setFirstName(rs.getString(3));
                    e.setBirth(rs.getString(4));
                    e.setPhoto(rs.getString(5));
                    e.setNote(rs.getString(6));
                    model.addAttribute("employee", e);
                }
            }
        }
    }

    @PostMapping("sub2/update2")
    public String update2(MyBean258Employees employee, RedirectAttributes rttr) throws SQLException {
        String sql = """
                UPDATE Employees
                SET LastName = ?,
                    FirstName = ?,
                    BirthDate =?,
                    Photo = ?,
                    Notes = ?
                    WHERE EmployeeID = ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try (conn; pstmt) {
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getBirth());
            pstmt.setString(4, employee.getPhoto());
            pstmt.setString(5, employee.getNote());
            pstmt.setInt(6, employee.getId());

            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", employee.getId() + " has been updated");
            } else {
                rttr.addFlashAttribute("message", "it has not been updated");
            }
        }


        rttr.addAttribute("id", employee.getId());
        return "redirect:/main30/sub2";
    }

}
