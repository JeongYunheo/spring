package com.study.controller;

import com.study.domain.MyBean411;
import com.study.domain.MyBean412;
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

    @GetMapping("sub5")
    @ResponseBody
    public MyBean411 sub5() {
        MyBean411 obj = new MyBean411();
        obj.setName("이강인");
        obj.setAge(55);

        return obj;
    }

    @GetMapping("sub6")
    @ResponseBody
    public MyBean412 sub6() {
        MyBean412 myBean412 = new MyBean412();
        myBean412.setTeam("spurs");
        myBean412.setMarried(false);
        MyBean411 myBean411 = new MyBean411();
        myBean411.setName("이강인");
        myBean411.setAge(55);
        myBean412.setInfo(myBean411);
        myBean412.setName("강인");
        return myBean412;
    }
}
