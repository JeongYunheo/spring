package com.study.controller;

import com.study.domain.MyBean101;
import com.study.domain.MyBean102;
import com.study.domain.MyBean103;
import com.study.domain.MyBean104;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {

    @RequestMapping("sub1")
    public void method1(Model model1) {
        var data = new HashMap<String, List>();
        data.put("key1", List.of("java", "css"));
        data.put("key2", List.of("react", "vue"));
        data.put("key 삼", List.of("spring", "node"));
        model1.addAttribute("myList", data);
        // view로 포워딩 (/WEB-INF/view/main10/sub1.jsp)

    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        var data = new ArrayList<Map>();
        data.add(Map.of("son", 7,
                "lee", 18,
                "kim", 4));

        data.add(Map.of("korea", "seoul",
                "japan", "tokyo",
                "미국", "워싱턴"));

        model.addAttribute("myAttr", data);

    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        var data = new HashMap<String, String>();
        data.put("흥민", "런던");
        data.put("강인", "파리");
        data.put("민재", "뮌헨");
        data.put("jh", "센프란시스코");

        model.addAttribute("myAttr1", data);
        model.addAttribute("myAttr2", "흥민");
        model.addAttribute("myAttr3", "민재");
        model.addAttribute("jh", "강인");

    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        var data = new ArrayList<Map>();
        data.add(Map.of("son", "london", "lee", "paris"));
        data.add(Map.of("korea", "seoul", "uk", "london"));
        data.add(Map.of("부산", "해운대"));
        data.add(Map.of("서울", "강남"));

        model.addAttribute("list1", data);
        model.addAttribute("number1", 1);
        model.addAttribute("two", 2);
        model.addAttribute("three", "3"); // 꼭 int 아니어도 됨
        model.addAttribute("3", "삼");
        model.addAttribute("data1", "son");
        model.addAttribute("data2", "lee");

    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        model.addAttribute("data", "값 1");
        model.addAttribute("데이타", "값 2");
        model.addAttribute("3", "삼");
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        var data = new ArrayList<MyBean101>();
        MyBean101 e1 = new MyBean101();
        MyBean101 e2 = new MyBean101();
        MyBean101 e3 = new MyBean101();

        e1.setName("흥민");
        e1.setAge(10);
        e1.setAddress("런던");

        e2.setName("강인");
        e2.setAge(24);
        e2.setAddress("파리");

        e3.setName("정후");
        e3.setAge(12);
        e3.setAddress("샌프란");

        data.add(e1);
        data.add(e2);
        data.add(e3);

        model.addAttribute("myList", data);

    }

    @RequestMapping("sub7")
    public void method7(Model model) {
        var list = new ArrayList<MyBean102>();

        MyBean102 e1 = new MyBean102();
        MyBean102 e2 = new MyBean102();
        MyBean102 e3 = new MyBean102();

        list.add(e1);
        list.add(e2);
        list.add(e3);

        e1.setModelName("kia");
        e1.setPrice(5000);
        e1.setColor("red");

        e2.setModelName("h");
        e2.setPrice(6000);
        e2.setColor("black");

        e3.setModelName("a");
        e3.setPrice(8000);
        e3.setColor("grey");

        model.addAttribute("cars", list);
    }

    @RequestMapping("sub8")
    public void method8(Model model) {
        var list = new ArrayList<MyBean103>();

        MyBean103 e1 = new MyBean103();
        MyBean103 e2 = new MyBean103();

        // ${myList[0].name}
        e1.setName("한국");
        // ${myList[0].cities[$]}
        e1.setCities(List.of("서울", "대구", "부산"));

        e2.setName("미국");
        e2.setCities(List.of("뉴욕", "LA"));

        list.add(e1);
        list.add(e2);


        model.addAttribute("myList", list);

    }

    @RequestMapping("sub9")
    public void method9(Model model) {
        var obj = new ArrayList<MyBean104>();

        MyBean104 e1 = new MyBean104();
        MyBean104 e2 = new MyBean104();

        obj.add(e1);
        obj.add(e2);

        e1.setCity("seoul");
        e1.setFoods(List.of("삼겹살", "김치", "짜장면"));

        e2.setCity("usa");
        e2.setFoods(List.of("pizza", "mac&cheese", "steak"));

        model.addAttribute("data", obj);
    }
}
