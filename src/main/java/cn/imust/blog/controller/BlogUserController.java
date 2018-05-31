package cn.imust.blog.controller;

import cn.imust.blog.entity.BlogUser;
import cn.imust.blog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class BlogUserController {

    @Autowired private BlogUserService blogUserService;

    @PostMapping("login")
    public String login(BlogUser user, HttpServletRequest request, HttpSession session) {
        BlogUser blogUser = blogUserService.login(user);
        if(blogUser != null){
            session.setAttribute("user",blogUser);
            if(blogUser.isAdmin()){
                return "redirect:/blog/admin";
            }else{
                return "redirect:/blog/index";
            }
        }else{
            request.setAttribute("error","用户名或密码错误!");
            return "/blog/loginForm";
        }
    }

    @RequestMapping("logout")
    public String login(HttpSession session){
        session.invalidate();
        return "redirect:/blog/loginForm";
    }
}
