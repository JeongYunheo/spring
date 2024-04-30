package com.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller38 {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/path1")
    @PreAuthorize("isAuthenticated()")
    public void path1() {
        System.out.println("Controller38.path1");
    }

    @GetMapping("/path2")
    @PreAuthorize("hasAnyAuthority('user')")
    public void path2() {
        System.out.println("user 권한이면 실행 가능");
    }

    @GetMapping("/path3")
    @PreAuthorize("hasAnyAuthority('admin')")
    public void path3() {
        System.out.println("admin 권한이면 실행 가능");
    }

    @GetMapping("/path4")
    public void path4() {

    }
}
