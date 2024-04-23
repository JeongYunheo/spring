package com.study.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application6 {
    public static void main(String[] args) {
        BeanFactory context = SpringApplication.run(Application6.class, args);
        Object b1 = context.getBean("myBean61");
        Object b2 = context.getBean("myClass62");
        MyClass61 b3 = context.getBean(MyClass61.class);
        MyClass62 b4 = context.getBean(MyClass62.class);
        System.out.println(b1 == b3);
        System.out.println(b2 == b4);
    }
}

// 2개 Component 만들기
@Component("myBean61")
class MyClass61 {
}

@Component
class MyClass62 {
}
