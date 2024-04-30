package com.study.service;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean258Employees;
import com.study.mapper.Mapper07;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class Service03 {
    private final Mapper07 mapper07;


    public void insertData() {
        MyBean258Employees e = new MyBean258Employees();
        e.setLastName("박");
        e.setFirstName("지성");
        mapper07.insert(e);
        System.out.println(e.getId());  // 새로 생성된 키값
    }

    public void insertData2() {
        MyBean254Customer c = new MyBean254Customer();
        // 새 고객 데이터 입력하고
        // 다음 출력 코드에서 새 고객의 키가 출력되도록
        c.setName("이강인");
        c.setContactName("paris");
        mapper07.insertCustomer(c);
        System.out.println(c.getId());
    }
}
