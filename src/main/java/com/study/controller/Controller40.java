package com.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class Controller40 {

    @GetMapping("/api/someurl")
    public void method1() {
        System.out.println("Controller40.method1");
    }

    @PostMapping("/api/someurl")
    public void method2() {
        System.out.println("Controller40.method2");
    }

    @GetMapping("/api/someurl2")
    public void method3() {
        System.out.println("Controller40.method3");
    }

    @PostMapping("/api/someurl2")
    public void method4() {
        System.out.println("Controller40.method4");
    }

    @GetMapping("/api/someurl3")
    public void method5(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("email") String email) {

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("email = " + email);
    }

    @PostMapping("/api/someurl3")
    public void method6(@RequestParam("id") Integer id,
                        @RequestParam("country") String country,
                        @RequestParam("city") String city) {

        System.out.println("id = " + id);
        System.out.println("country = " + country);
        System.out.println("city = " + city);
    }

    @GetMapping("/api/someurl4")
    public void method7(@RequestParam("id") Integer id,
                        @RequestParam("team") String team,
                        @RequestParam("position") String position) {
        System.out.println("id = " + id);
        System.out.println("team = " + team);
        System.out.println("position = " + position);

    }

    @PostMapping("/api/someurl4")
    public void method8(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("email") String[] email) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("email = " + Arrays.toString(email));
    }
}
