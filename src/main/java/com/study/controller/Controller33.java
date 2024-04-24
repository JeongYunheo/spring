package com.study.controller;

import com.study.domain.MyBean331;
import com.study.domain.MyBean332;
import com.study.domain.MyBean333;
import com.study.mapper.Mapper04;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("main33")
@RequiredArgsConstructor
public class Controller33 {

    private final Mapper04 mapper04;

    @GetMapping("sub1")
    public void method1() {
        List<MyBean331> obj = mapper04.select1();
        obj.forEach(System.out::println);
    }

    @GetMapping("sub2")
    public void method2() {
        List<MyBean332> obj = mapper04.select2();
        obj.forEach(System.out::println);
    }

    // 세번째 메소드 작성
    // mapper.select3() 호출 결과
    // List<MyBean333>
    // SELECT * FROM my_table10
    @GetMapping("sub3")
    public void method3() {
        List<MyBean333> obj = mapper04.select3();
        obj.forEach(System.out::println);
    }

    @GetMapping("sub4")
    public void method4() {
        mapper04.insert1("hello world", "564321", "876.54", "2024-01-02", "2024-02-02 14:14:14");

    }

    @GetMapping("sub5")
    public void method5() {
        String strVal = "hello world";
        Integer intVal = 7890;
        Double doublelVal = 3.14;
        LocalDate dateVal = LocalDate.parse("2024-01-02");
        LocalDateTime dateTimeVal = LocalDateTime.parse("2024-02-02T14:14:14");
        mapper04.insert2(strVal, intVal, doublelVal, dateVal, dateTimeVal);
    }

    // 6번째 메소드
    // my_table10 레코드 추가
    @GetMapping("sub6")
    public void method6() {
        String title = "이것이 스프링이다";
        String name = "신용권";
        Integer age = 50;
        Double price = 3.14;
        LocalDate published = LocalDate.parse("2024-01-02");
        LocalDateTime inserted = LocalDateTime.parse("2024-02-02T14:14:14");
        mapper04.insert3(title, name, age, price, published, inserted);
    }

    @GetMapping("sub7")
    public void method7() {
        MyBean332 obj = new MyBean332();
        obj.setStringCol("hello");
        obj.setIntCol(3090);
        obj.setDateCol(LocalDate.parse("2024-01-02"));
        obj.setDateTimeCol(LocalDateTime.parse("2024-02-02T14:14:14"));
        obj.setDecCol(99.78);

        mapper04.insert4(obj);
    }

    // 8 method
    // my_table10ㅇㅔ 레코드 작성
    // MyBean333 활용
    @GetMapping("sub8")
    public void method8() {
        MyBean333 obj = new MyBean333();
        obj.setTitle("스프링");
        obj.setName("신용권");
        obj.setAge(50);
        obj.setPrice(3.14);
        obj.setPublished(LocalDate.parse("2024-01-02"));
        obj.setInserted(LocalDateTime.parse("2024-02-02T14:14:14"));

        mapper04.insert5(obj);
    }


    @GetMapping("sub9")
    public void select9(Model model) {
        List<MyBean332> list = mapper04.select2();
        model.addAttribute("datas", list);
    }

    @PostMapping("sub9")
    public String insert9(String str, String intValue, String realValue, String dateValue, String dateTimeValue) {
        mapper04.insert1(str, intValue, realValue, dateValue, dateTimeValue);

        return "redirect:/main33/sub9";
    }

    @GetMapping("sub10")
    public String select10(Model model) {
        List<MyBean332> list = mapper04.select2();
        model.addAttribute("datas", list);

        return "/main33/sub9";
    }

    @PostMapping("sub10")
    public String insert10(String str, Integer intValue, Double realValue, LocalDate dateValue, LocalDateTime dateTimeValue) {
        mapper04.insert2(str, intValue, realValue, dateValue, dateTimeValue);
        return "redirect:/main33/sub10";
    }


    @GetMapping("sub11")
    public String select11(Model model) {
        List<MyBean332> list = mapper04.select2();
        model.addAttribute("datas", list);

        return "/main33/sub11";
    }

    @PostMapping("sub11")
    public String insert11(MyBean332 data) {
//        System.out.println("data = " + data);
        mapper04.insert4(data);
        return "redirect:/main33/sub10";
    }


    // my_table10 레코드 입력 및 로직 완성
    @GetMapping("sub12")
    public void select12(Model model) {
        List<MyBean333> list = mapper04.select3();
        model.addAttribute("datas", list);
    }

    @PostMapping("sub12")
    public String insert12(MyBean333 data) {
        mapper04.insert5(data);
        return "redirect:/main33/sub12";
    }
}
