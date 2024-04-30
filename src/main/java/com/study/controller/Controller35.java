package com.study.controller;

import com.study.service.Service02;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main35")
public class Controller35 {

    private final Service02 service02;

    @GetMapping("sub1")
    public void sub1() {
        service02.transferMoney1();
    }

    @GetMapping("sub2")
    public void sub2() {
        service02.transferMoney2();
    }

    @GetMapping("sub3")
    public void sub3() throws Exception {
        // checked exception은 roll back 안됨
        service02.transferMoney3();
    }

    @GetMapping("sub4")
    public void sub4() throws Exception {
        service02.transferMoney4();
    }

    @GetMapping("sub5")
    public void sub5() {
        service02.transferMoney5();
    }
}
