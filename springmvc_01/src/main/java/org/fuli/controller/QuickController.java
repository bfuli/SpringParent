package org.fuli.controller;

import org.apache.commons.io.IOUtils;
import org.fuli.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Controller
public class QuickController {
    //restful风格
    @RequestMapping("/hello/{id}")
    public String helloRest(@PathVariable("id") int id){
        System.out.println("show");
        return "/index.jsp";
    }
    @RequestMapping("/hello")
    public String hello(int id){
        System.out.println("show");
        return "/index.jsp";
    }
    @RequestMapping("/header")
    public String header(@RequestHeader Map<String, String> map){
        System.out.println("show");
        return "/index.jsp";
    }
    @RequestMapping("/cookie")
    public String cookie(@CookieValue Map<String, String> map){
        System.out.println("show");
        return "/index.jsp";
    }

    @RequestMapping("/user")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setAge(10);
        user.setName("ha");
        return user;
    }
}
