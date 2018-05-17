package cn.imust.blog.controller;

import cn.imust.blog.entity.Links;
import cn.imust.blog.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping (value = "/index")
public class IndexController {
    @Autowired private LinksService linksService;

    @RequestMapping (value = "test")
    public String findAll(Model model){
        List<Links> links = linksService.findAll();
        model.addAttribute("links",links);
        return "index";
    }

}
