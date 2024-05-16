package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/main42")
public class Controller42 {

    @GetMapping("sub1")
    @ResponseBody
    public String sub1() {

        return "어떤 데이터";
    }

    @GetMapping("sub2")
    @ResponseBody
    public String sub2() {
        double random = Math.random();
        String result = "";
        if (random < 1.0 / 3) {
            return "가위";
        } else if (random < 2.0 / 3) {
            return "바위";
        }
        return "보";
    }

    @GetMapping("sub3")
    @ResponseBody
    public Map<String, Object> sub3() {
        return Map.of("name", "흥민",
                "age", 25,
                "married", false,
                "info", Map.of("team", "tottenham", "location", "런던"),
                "item", List.of("축구공", "운동화", "유니폼"));

    }

    @GetMapping("sub4")
    @ResponseBody
    public Map<String, Object> sub4() {
        return Map.of("id", 3,
                "country", "usa",
                "height", 188.09,
                "foods", List.of("pizza", "latte"),
                "hasAccess", false);
    }
    
}