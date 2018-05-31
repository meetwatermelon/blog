package cn.imust.blog.service;

import cn.imust.blog.entity.BlogUser;
import cn.imust.blog.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BlogUserService {

    @Autowired private BlogUserRepository blogUserRepository;

    public void save(BlogUser blogUser){
        blogUserRepository.save(blogUser);
    }

    public BlogUser login(BlogUser user) {
        return blogUserRepository.findBlogUsersByEmailAndPwd(user.getEmail() , user.getPwd());
    }
}
