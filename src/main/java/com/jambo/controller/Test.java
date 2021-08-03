package com.jambo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping("/hello")
    public String hello() {
//        System.out.println("hello");
        System.out.println("nihao");
        return "hello";
    }

}
