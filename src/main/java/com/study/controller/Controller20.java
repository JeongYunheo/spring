package com.study.controller;

import com.study.domain.MyBean201;
import com.study.domain.MyBean202;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @RequestMapping("sub1")
    public void sub1() {
    }

    @RequestMapping("sub2")
    public void sub2() {
    }

    @RequestMapping("sub3")
    public void sub3() {
    }

    @RequestMapping("sub4")
    public void sub4() {
    }

    @RequestMapping("sub5")
    public void sub5(String player, Model model) {
        // 1. 요청, 분석, 가공
        // 2. 비지니스 로직 처리
        // 3. 결과를 모델에 담고
        model.addAttribute("result", player + " 검색결과");
        // 4. 뷰로 forward (이름 리턴)
    }

    @RequestMapping("sub6")
    public void sub6(String address, String type, Model model) {
        model.addAttribute("result", address + "의 " + type + " 검색결과");
    }

    @RequestMapping("sub7")
    public void sub7(String name,
                     Integer age,
                     LocalDate birth,
                     String address,
                     String hobby,
                     Model model) {
        model.addAttribute("result", name + "의 나이는" + age);
        System.out.println("birth = " + birth);
        System.out.println("address = " + address);
        System.out.println("hobby = " + hobby);
    }

    @RequestMapping("sub8")
    public void sub8(MyBean201 data) {
        // @ModelAttribute 생략 가능
        System.out.println("data = " + data);

    }

    @RequestMapping("sub9")
    public void sub9() {
        // todo: sub9.jsp > city, address, title, content param form
        // location: main20/sub10
    }

    @RequestMapping("sub10")
    public void sub10(MyBean202 data, Model model) {
        // main20/sub10 method
        // request param > MyBean202 binding
        model.addAttribute("result", data);
        System.out.println("data = " + data);
    }

    @RequestMapping("sub11")
    public void sub11() {

    }

    @RequestMapping("sub12")
    public void sub12(String type,
                      String content,
                      String city) {
        System.out.println("type = " + type);
        System.out.println("content = " + content);
        System.out.println("city = " + city);
    }

    @RequestMapping("sub13")
    public void sub13(String city) {
        System.out.println("city = " + city);
    }

    @RequestMapping("sub14")
    public void sub14(@RequestParam("foods") String[] foods) {
        // @RequestParam("foods") : 생략 가능
        System.out.println(Arrays.toString(foods));
    }

    @RequestMapping("sub15")
    public void sub15(String type,
                      String phone,
                      String[] book) {
        System.out.println("type" + type);
        System.out.println("phone" + phone);
        System.out.println("book" + Arrays.toString(book));

    }

    @RequestMapping("sub16")
    public void sub16() {

    }

    @RequestMapping("sub17")
    public void sub17(String id, String password, String describe) {
        System.out.println("id = " + id);
        System.out.println("password = " + password);
        System.out.println("describe = " + describe);
    }

    @RequestMapping("sub18")
    public void sub18(String name, String city, String address) {
        System.out.println("name = " + name);
        System.out.println("city = " + city);
        System.out.println("address = " + address);
    }

}
