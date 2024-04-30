package com.study.service;

import com.study.domain.MyBean258Employees;
import com.study.mapper.Mapper08;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class Service04 {

    private final Mapper08 mapper08;

    public void action1() {
        mapper08.query1();
    }

    public void action2() {
        MyBean258Employees e = new MyBean258Employees();
//        e.setLastName("흥민");

        mapper08.query2(e);
    }

    public void action3() {
        MyBean258Employees e = new MyBean258Employees();
        e.setFirstName("lee");
        mapper08.query3(e);
    }

    public void action4() {
        MyBean258Employees e = new MyBean258Employees();
        e.setFirstName("kim");
        e.setFirstName("lee");
        mapper08.query4(e);
    }

    public void action5() {
        MyBean258Employees e = new MyBean258Employees();
        e.setLastName("son");
        e.setFirstName("hm");
        mapper08.query5(e);
    }

    public void action6(String keyword) {

        List<MyBean258Employees> list = mapper08.query6(keyword);
        list.forEach(System.out::println);
    }

    public void action7() {
        mapper08.query7();
    }
}
