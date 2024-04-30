package com.study.controller;

import com.study.service.Service04;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("main37")
public class Controller37 {
    private final Service04 service04;

    @GetMapping("sub1")
    public void method1() {
        service04.action1();
    }

    @GetMapping("sub2")
    public void method2() {
        service04.action2();
    }

    @GetMapping("sub3")
    public void method3() {
        service04.action3();
    }

    @GetMapping("sub4")
    public void method4() {
        service04.action4();
    }

    @GetMapping("sub5")
    public void method5() {
        service04.action5();
    }

    // main37/sub6?q=bts
    @GetMapping("sub6")
    public void method6(
            @RequestParam(value = "q", defaultValue = "") String keyword) {
        service04.action6(keyword);
    }

    @GetMapping("sub7")
    public void method7() {
        service04.action7();
    }
}
