package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main5")
public class Controller05 {
    // Spring 코드를 줄여 사용(annotation 사용해서)

    // /main5/sub1?city=seoul
    // /main5/sub1?city=london
    @RequestMapping("sub1")
    public void method1(@RequestParam("city") String param) {
        System.out.println(param + " 검색로직 실행");
    }

    // /main5/sub2?address=sinchon
    // /main5/sub2?address=gangnam
    // /main5/sub2?address=hongdae

    // ~로 가는 경로 탐색
    @RequestMapping("sub2")
    public void method2(@RequestParam("address") String param) {
        System.out.println(param + "로 가는 경로 탐색");
    }

    // /main5/sub3?age=13
    // /main5/sub3?age=20
    // /main5/sub3?age=40
    // /main5/sub3?age=70
    @RequestMapping("sub3")
    public void method3(@RequestParam("age") Integer param) {
        if (param < 18) {
            System.out.println("청소년 관련 정보 출력");
        } else if (param < 35) {
            System.out.println("성인 관련 정보 출력");
        } else if (param < 65) {
            System.out.println("중장년 관련 정보 출력");
        } else {
            System.out.println("노인 관련 정보 출력");
        }
    }

    // /main5/sub4?height=125.0
    // /main5/sub4?height=145.1
    // /main5/sub4?height=180.5

    // 0~145.0 사이는 작은 키
    // 145~170.0 사이는 보통 키
    // 170~ 사이는 큰 키
    @RequestMapping("sub4")
    public void method4(@RequestParam("height") Double param) {
        if (param < 145.0) {
            System.out.println("작은키");
        } else if (param < 170.0) {
            System.out.println("보통키");
        } else {
            System.out.println("큰키");
        }
    }
}
