package cn.imust.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping(value = "/blog")
public class HTMLTest {
    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "admin")
    public String admin(){
        return "admin/admin";
    }
    @RequestMapping(value = "galleryadd")
    public String galleryadd(){
        return "admin/album/galleryadd";
    }
    @RequestMapping(value = "gallery")
    public String gallery(){
        return "admin/album/gallery";
    }
    @RequestMapping(value = "addarticle")
    public String addarticle(){
        return "admin/article/addarticle";
    }
    @RequestMapping(value = "article")
    public String article(){
        return "admin/article/article";
    }

}
