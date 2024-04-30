package com.study.mapper;

import com.study.domain.MyBean258Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper08 {

    @Select("""
            <script>
            SELECT *
            FROM Employees
            WHERE LastName = 'abc'
               <if test="false">
                OR FirstName = 'abc'
               </if>
            </script>
            """)
    List<MyBean258Employees> query1();

    @Select("""
               <script>
               SELECT *
               FROM my_table
                <if test="lastName != null">
                    -- name이 null이 아닐 떄 포함되는 code... #{name}
                </if>
                <if test="lastName == null">
                    -- name이 null일 떄 포함되는 code...
                </if>
               </script>
            """)
    Object query2(MyBean258Employees e);

    @Select("""
            <script>
            SELECT *
            FROM my_table
                <if test="firstName == 'lee'">
                    -- firstName 이 lee일 때
                </if>
                <if test="firstName != 'lee'">;
                    -- firstName이 lee가 아닐때
                </if>
            </script>
            """)
    Object query3(MyBean258Employees e);

    @Select("""
            <script>
            SELECT *
            FROM my_table
                <if test="firstName == null">
                    -- firstName이 null일 때
                </if>
                <if test="firstName != null">;
                    -- firstName null이 아닐때
                </if>
                <if test="firstName == 'kim'">;
                    -- firstName "kim"일 때
                </if>
                <if test="firstName == 'lee'">;
                    -- firstName "lee"일 때
                </if>
            </script>
            """)
    Object query4(MyBean258Employees e);

    @Select("""
            <script>
            SELECT *
            FROM my_table
                <trim prefix="WHERE" prefixOverrides="OR">
                    <if test="lastName != null">
                    OR    LastName = #{lastName}
                    </if>
                    <if test="firstName != null">
                    OR    FirstName = #{firstName}
                    </if>
                </trim>
            </script>
            """)
    Object query5(MyBean258Employees e);

    @Select("""
            <script>
            <bind name="patternKeyword" value = '"%" + keyword + "%"'/>
            SELECT * FROM Employees
            WHERE notes LIKE #{keyword}
            </script>
            """)
    List<MyBean258Employees> query6(String keyword);

    @Select("""
            <script>
            <![CDATA[
             SELECT * FROM Products
             WHERE Price < 5
            ]]>
            </script>
            """)
    Object query7();

}
