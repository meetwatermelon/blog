package cn.imust.blog.controller;

import cn.imust.blog.entity.Article;
import cn.imust.blog.entity.BlogUser;
import cn.imust.blog.entity.Category;
import cn.imust.blog.entity.Comment;
import cn.imust.blog.service.ArticleService;
import cn.imust.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "addarticle")
    public String addArticle(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/article/addarticle";
    }

    @RequestMapping(value = "savearticle")
    public String saveArticle(Article article) {
        articleService.saveArticle(article);
        return "redirect:findarticle";
    }

    @RequestMapping(value = "findarticle")
    public String findArticle(Model model,
                              @RequestParam(required = false, defaultValue = "0") Integer page,
                              @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<Article> articlePage = articleService.findArticle(page,pageSize);
        model.addAttribute("articlesPage", articlePage);
        return "/admin/article/articlelist";
    }

    @RequestMapping(value = "deletearticle/{id}")
    public String deleteArticle(@PathVariable int id) {
        articleService.deleterArticle(id);
        return "redirect:/article/findarticle";
    }

    @RequestMapping(value = "goupdate/{id}")
    public ModelAndView goUpdate(@PathVariable int id, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Article article = articleService.getOneArticle(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("/admin/article/updatearticle");
        return modelAndView;
    }

    @RequestMapping(value = "update")
    public String updateArticle(Article article) {
        article.setDate(new Date());
        articleService.updateArticle(article);
        return "redirect:/article/findarticle";
    }


    @PostMapping("addComment")
    public String addComment(Comment comment, HttpServletRequest request) {
        comment.setDate(new Date());
        BlogUser user = (BlogUser) request.getSession().getAttribute("user");
        comment.setQuser(user);
        articleService.addComment(comment);
        return "redirect:/blog/index";
    }

    //这里有问题,普通用户回复和管理员回复跳转了一个页面
    @PostMapping("backComment")
    public String backComment(Comment comment, HttpServletRequest request) {
        comment.setDate(new Date());
        BlogUser user = (BlogUser) request.getSession().getAttribute("user");
        comment.setAuser(user);
        articleService.backComment(comment);
        return "redirect:/comment/findAll";
    }

}
