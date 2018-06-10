package cn.imust.blog.controller;

import cn.imust.blog.entity.Article;
import cn.imust.blog.entity.Category;
import cn.imust.blog.entity.Links;
import cn.imust.blog.service.ArticleService;
import cn.imust.blog.service.CategoryService;
import cn.imust.blog.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping (value = "/blog")
public class IndexController {
    @Autowired private LinksService linksService;
    @Autowired private ArticleService articleService;
    @Autowired private CategoryService categoryService;

    @RequestMapping (value = "index")
    public String findAll(Model model){
        List<Links> links = linksService.findAll();
        model.addAttribute("links",links);

        List<Article> articles = articleService.findArticle();
        model.addAttribute("articles",articles);

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "client/index";
    }

    @RequestMapping (value = "showarticle/{id}")
    public String showArticle(@PathVariable int id,Model model){
        Article article = articleService.getOneArticle(id);
        model.addAttribute("article",article);
        List<Links> links = linksService.findAll();
        model.addAttribute("links",links);
        return "client/article";
    }

}
