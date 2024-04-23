package com.study.core;

import lombok.Getter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application15 {
    public static void main(String[] args) {
        BeanFactory context = SpringApplication.run(Application15.class, args);
        MyClass152 d = context.getBean(MyClass151.class).getDependency();
        // null 이 아니게 setter 주입
        System.out.println("d = " + d);
    }
}

@Component
@Getter
class MyClass151 {
    private MyClass152 dependency;

    @Autowired
    public void setDependency(MyClass152 dependency) {
        this.dependency = dependency;
    }
}

@Component
class MyClass152 {

}