package com.study.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application16 {
    public static void main(String[] args) {
        BeanFactory context = SpringApplication.run(Application16.class, args);
        MyClass161 bean = context.getBean(MyClass161.class);
        bean.action();

    }
}


@Component
@RequiredArgsConstructor
class MyClass161 {
    private final MyInterface161 field;

    public void action() {
        field.someMethod();
    }
}

interface MyInterface161 {
    public void someMethod();
    // dependency 옮겨갈 때, 모든 조건들을 변경하는 대신
    // interface 이용해서 모든 객체 활용
}

@Component
class MyClass163 implements MyInterface161 {
    public void someMethod() {
        System.out.println("some Method222222");
    }
}

// @Component
class MyClass162 implements MyInterface161 {
    public void someMethod() {
        System.out.println("some action1111111");
    }
}

