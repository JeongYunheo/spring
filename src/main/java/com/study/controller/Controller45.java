package com.study.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// @Controller
// @ResponseBody   // 모든 메소드에 적용
@RestController // Controller + ResponseBody
@RequestMapping("/api/main45")
public class Controller45 {

    @PostMapping("sub1")
    public String sub1(@RequestParam("name") String name,
                       @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("name = " + name);
        System.out.println("file = " + file.getOriginalFilename());
        System.out.println("file.getSize() = " + file.getSize());

        String path = "C:/Windows/Temp/" + file.getOriginalFilename();
        file.transferTo(new File(path));

        return null;
    }

    @PostMapping("sub2")
    @ResponseBody
    public String sub2(@RequestParam("name") String name,
                       @RequestParam("file[]") MultipartFile[] file) throws IOException {
        System.out.println("name = " + name);
        if (file != null || file.length > 0) {
            for (MultipartFile f : file) {
                if (f.getSize() > 0) {
                    String path = "C:/Windows/Temp/" + f.getOriginalFilename();
                    f.transferTo(new File(path));
                }
            }
        }

        return null;
    }
}
