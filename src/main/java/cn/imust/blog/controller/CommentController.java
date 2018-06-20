package cn.imust.blog.controller;

import cn.imust.blog.entity.Comment;
import cn.imust.blog.repository.CommentRepository;
import cn.imust.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired private CommentService commentService;
    @Autowired private CommentRepository commentRepository;

    @GetMapping("findAll")
    public String findAll(Model model){
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments",comments);
        return "/admin/comment/comment";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        commentService.delete(id);
        return "redirect:/comment/findAll";
    }

    @RequestMapping("report/{id}")
    public String report(@PathVariable Integer id){
        Comment one = commentRepository.findOne(id);
        one.setReport(true);
        commentRepository.saveAndFlush(one);
        return "redirect:/comment/findAll";
    }
}
