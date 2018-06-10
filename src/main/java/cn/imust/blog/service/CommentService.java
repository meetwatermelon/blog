package cn.imust.blog.service;

import cn.imust.blog.entity.Comment;
import cn.imust.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired private CommentRepository commentRepository;

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public void delete(Integer id) {
        commentRepository.delete(id);
    }
}
