package com.study.controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean256Product;
import com.study.domain.MyBean258Employees;
import com.study.mapper.Mapper02;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main31")
@RequiredArgsConstructor
public class Controller31 {

    private final Mapper02 mapper;

    @GetMapping("sub1")
    public void method1() {
        String now = mapper.selectNow();
        System.out.println("now = " + now);
    }

    @GetMapping("sub2")
    public String method2() {
        MyBean254Customer customer = mapper.selectOneCustomer();
        System.out.println("customer = " + customer);

        return null;
    }

    @GetMapping("sub3")
    public void method3() {
        MyBean254Customer c = mapper.selectOneCustomer2();
        System.out.println("c = " + c);
    }

    @GetMapping("sub4")
    public void method4() {
        MyBean254Customer c = mapper.selectOneCustomer3();
        System.out.println("c = " + c);
    }

    @GetMapping("sub5")
    public void method5() {
        // 2번 직원의 정보 조회 후 출력
        MyBean258Employees e = mapper.selectOneEmployee1();
        System.out.println("e = " + e);
    }

    @GetMapping("sub6")
    public void method6() {
        MyBean258Employees e = mapper.selectOneEmployee2(4);
        System.out.println("e = " + e);
    }

    @GetMapping("sub7")
    public void method7(Integer id) {
        MyBean258Employees e = mapper.selectOneEmployee2(id);
        System.out.println("e = " + e);
    }

    @GetMapping("sub8")
    public void method8() {
        MyBean254Customer c = mapper.selectOneCustomer4(20);
        System.out.println("c = " + c);
    }

    @GetMapping("sub9")
    public void method9() {
        List<MyBean254Customer> customer = mapper.selectAllCustomer1();
        System.out.println("customer = " + customer.size());
    }

    // /main31/sub10
    // 모든 직원을 조회한 결과 콘솔에 출력
    @GetMapping("sub10")
    public void method10() {
        List<MyBean258Employees> e = mapper.selectAllEmployee();
        e.forEach(System.out::println);
    }

    @GetMapping("sub11")
    public void method11() {
        List<MyBean254Customer> list = mapper.selectCustomersByCountry("usa", "uk");
        list.forEach(System.out::println);
    }

    // /main31/sub12/min=5&max=55
    // 가격이 5부터 55 사이인 상품 조회 후 콘솔에 출력
    @GetMapping("sub12")
    public void method12(Double min, Double max) {
        List<MyBean256Product> list = mapper.selectProductByPrice(min, max);
        list.forEach(System.out::println);

    }
}

