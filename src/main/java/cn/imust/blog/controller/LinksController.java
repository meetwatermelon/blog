package cn.imust.blog.controller;

import cn.imust.blog.entity.Links;
import cn.imust.blog.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "links")
public class LinksController {

    @Autowired private LinksService linksService;

    @PostMapping(value = "savelink")
    public String save(Links links){
        linksService.save(links);
        return "redirect:findlinks";
    }

    @RequestMapping(value = "addlink")
    public String addlink(){
        return "admin/links/addlinks";
    }

    @RequestMapping(value = "findlinks")
    public String findAll(Model model){
        List<Links> links = linksService.findAll();
        model.addAttribute("links",links);
        return "admin/links/links";
    }

    @RequestMapping(value = "deletelink/{id}")
    public String delete(@PathVariable int id){
        linksService.delete(id);
        return "redirect:findAll";
    }


}
