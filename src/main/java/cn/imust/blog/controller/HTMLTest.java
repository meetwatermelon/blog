package cn.imust.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping(value = "/blog")
public class HTMLTest {
    @RequestMapping(value = "loginForm")
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
    @RequestMapping(value = "articlelist")
    public String articlelist(){
        return "admin/article/articlelist";
    }
    @RequestMapping(value = "article")
    public String article(){
        return "client/article";
    }
    @RequestMapping(value = "comment")
    public String comment(){
        return "admin/comment/comment";
    }
    @RequestMapping(value = "links")
    public String links(){
        return "admin/links/links";
    }

    @RequestMapping("error")
    public String error(){
        int a = 1/0;
        return "";
    }

}
