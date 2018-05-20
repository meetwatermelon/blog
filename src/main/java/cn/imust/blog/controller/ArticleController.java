package cn.imust.blog.controller;

import cn.imust.blog.entity.Article;
import cn.imust.blog.entity.Category;
import cn.imust.blog.service.ArticleService;
import cn.imust.blog.service.CategoryService;
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
    @Autowired private CategoryService categoryService;

    @RequestMapping (value = "addarticle")
    public String addArticle(Model model){
       List<Category> categories = categoryService.findAll();
       model.addAttribute("categories",categories);
        return "admin/article/addarticle";
    }

    @RequestMapping (value = "savearticle")
    public String saveArticle(Article article){
        articleService.saveArticle(article);
        return "redirect:findarticle";
    }

    @RequestMapping (value = "findarticle")
    public String findArticle(Model model){
        List<Article> articles = articleService.findArticle();
        model.addAttribute("articles",articles);
        return "admin/article/articlelist";
    }

    @RequestMapping (value = "deletearticle/{id}")
    public String deleteArticle(@PathVariable int id){
        articleService.deleterArticle(id);
        return "redirect:/article/findarticle";
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

    @RequestMapping (value = "showCategory/{id}")
    public String showCategory(@PathVariable int id,Model model){
        List<Article> articles = articleService.getByCategoryID(id);
        model.addAttribute("articles",articles);
        return "client/categories";
    }

}
