package cn.imust.blog.controller;

import cn.imust.blog.entity.Article;
import cn.imust.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping (value = "/article")
public class ArticleController {

    @Autowired private ArticleService articleService;

    @RequestMapping (value = "addarticle")
    public String addArticle(){
       return "admin/article/addarticle";
    }

    @RequestMapping (value = "savearticle")
    public String saveArticle(Article article){
        articleService.saveArticle(article);
        return "redirect:articlelist";
    }

    @RequestMapping (value = "findarticle")
    public String findArticle(Model model){
        List<Article> list = articleService.findArticle();
        model.addAttribute("list",list);
        return "admin/article/articlelist";
    }

    @RequestMapping (value = "deletearticle/{id}")
    public String deleteArticle(@PathVariable int id){
        articleService.deleterArticle(id);
        return "redirect:articlelist";
    }

    @RequestMapping (value = "goupdate")
    public String goUpdate(){
        return "admin/article/updatearticle";
    }

    @RequestMapping (value = "update/{id}")
    public String updateArticle(@PathVariable int id){
        Article article = articleService.getOneArticle(id);
        articleService.updateArticle(article);
        return "admin/article/updatearticle";
    }


}
