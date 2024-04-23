package com.study.mapper;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean258Employees;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Mapper03 {

    @Delete("""
            DELETE FROM Customers
            WHERE CustomerID = 1
            """)
    int deleteOneCustomer();


    @Delete("""
            DELETE FROM Customers
            WHERE CustomerID = #{id}
            """)
    int deleteOneCustomerByID(int id);

    @Delete("""
            DELETE FROM Employees
            WHERE EmployeeID = #{e}
            """)
    int deleteOneEmployeeID(Integer e);

    @Insert("""
            INSERT INTO Customers
            (CustomerName, ContactName, Address, City, Postalcode, Country)
            VALUES 
            (#{name}, #{contactName}, #{address}, #{city}, #{postalCode}, #{countryName})
            """)
        // get method 이용
    int insetCustomer(MyBean254Customer customer);

    @Insert("""
            INSERT INTO Employees
            (LastName, FirstName, BirthDate, Photo, Notes)
            VALUES (#{lastName}, #{firstName}, #{birth}, #{photo}, #{note})
            """)
    int insertEmployee(MyBean258Employees employee);

    @Update("""
            UPDATE Employees
            SET LastName = #{lastName},
                FirstName = #{firstName},
                Photo = #{photo},
                Notes = #{note},
                BirthDate = #{birth}
            WHERE EmployeeID = #{id}
            """)
    int updateEmployee(MyBean258Employees employees);

    @Update("""
            UPDATE Customers
            SET CustomerName = #{name},
                ContactName = #{contactName},
                Address = #{address},
                City = #{city},
                PostalCode = #{postalCode},
                Country = #{countryName}
            WHERE CustomerID = #{id}
            """)
    int updateCustomer(MyBean254Customer customer);
}
