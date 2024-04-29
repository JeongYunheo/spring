package com.study.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper05 {

    @Data
    static class EmployeeIncome {
        private Integer employeeID;
        private String lastName;
        private String firstName;
        private Double income;
    }

    @Select("""
            SELECT e.EmployeeID,
                   e.LastName,
                   e.FirstName,
                    SUM(od.Quantity*p.Price) AS income
            FROM Orders o JOIN Employees e ON o.employeeID = e.EmployeeID
                          JOIN OrderDetails od ON od.OrderID = o.OrderID
                          JOIN Products p ON p.ProductID = od.ProductID
            WHERE o.Orderdate BETWEEN #{from} AND #{to}
            GROUP BY e.EmployeeID
            ORDER BY income DESC
            """)
    List<EmployeeIncome> selectIncomeList(String from, String to);

    @Data
    static class CustomerPurchase {
        private Integer customerID;
        private String customerName;
        private Double income;
    }

    @Select("""
            SELECT c.CustomerID,
                   c.CustomerName,
                    SUM(od.Quantity*p.Price) AS income
            FROM Orders o JOIN Customers c ON c.CustomerID = o.CustomerID
                          JOIN OrderDetails od ON od.OrderID = o.OrderID
                          JOIN Products p ON p.ProductID = od.ProductID
            WHERE o.Orderdate BETWEEN #{from} AND #{to}
            GROUP BY c.CustomerID
            ORDER BY income DESC
            """)
    List<CustomerPurchase> selectCustomerPurchaseList(String from, String to);
}
