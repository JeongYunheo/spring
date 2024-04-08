package com.study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main8")
public class Controller08 {

    @RequestMapping("sub1")
    public void sub1(Model model) {
        // 요청 분석.가공
        // 비지니스 로직 처리
        // 결과를 model에 담고 (object파일이기 때문에 모두 넣을 수 있음)
        model.addAttribute("name1", "value1");
        model.addAttribute("name2", "value2");
        // view로 포워딩(/WEB-INF/view/main8/sub1.jsp

    }

    @RequestMapping("sub2")
    public void sub2(Model model) {
        model.addAttribute("city", "서울");
        model.addAttribute("address", "신촌");

    }

    @RequestMapping("sub3")
    public void sub3(Model model) {
        model.addAttribute("name", "허정윤");
        model.addAttribute("age", "10");
    }

    @RequestMapping("sub4")
    public void sub4(Model model) {
        // model attribute의 name: String
        // model attribute의 name: Object

        // 따라서 model attribute의 value는 무엇이든지 될 수 있다
        // 자주 사용하는 타입
        // String, 기본타입(Wrapper)
        // List, Map
        // JavaBeans


        // 배열
        model.addAttribute("car",
                new String[]{"tesla", "kia", "hyundai"});
    }

    @RequestMapping("sub5")
    public void sub5(Model model) {
        model.addAttribute("cities", new String[]{"서울", "대구", "부산"});
        model.addAttribute("countries", new String[]{"한국", "미국", "케냐"});

        // jsp > 서울대구부산한국미국케냐 출력
    }

    @RequestMapping("sub6")
    public void sub6(Model model) {
        List<String> data = List.of("java", "css", "html", "jsp");
        model.addAttribute("myList", data);

        // /main8/sub6.jsp
    }

    @RequestMapping("sub7")
    public void sub7(Model model) {
        List<String> data = List.of("😊", "❤️", "*★,°*:.☆(￣▽￣)/$:*.°★* 。");
        model.addAttribute("myList", data);

        model.addAttribute("yourList", List.of(10, 5, 0));
    }

    @RequestMapping("sub8")
    public void sub8(Model model) {
        List<Double> numbers = List.of(500.0, 3.14);
        model.addAttribute("numbers", numbers);

        model.addAttribute("cities", List.of("서울", "런던", "뉴욕"));
    }

    @RequestMapping("sub9")
    public void sub9(Model model) {
        // model attribute 의 값이 map일 때
        Map<String, String> map = new HashMap<>();
        map.put("name", "흥민");
        map.put("age", "서른");
        map.put("address", "런던");

        model.addAttribute("myMap", map);

    }

    @RequestMapping("sub10")
    public void sub10(Model model) {
        Map<String, String> names = Map.of("son", "토트넘",
                "lee", "파리",
                "kim", "뮌헨");
        model.addAttribute("names", names);

        Map<String, String> others = Map.of("손흥민", "spurs",
                "lee kang in", "psg");
        model.addAttribute("others", others);
    }
}
