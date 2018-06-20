package cn.imust.blog.service;

import cn.imust.blog.entity.Article;
import cn.imust.blog.entity.Comment;
import cn.imust.blog.repository.ArticleRepository;
import cn.imust.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleService {
    @Autowired private ArticleRepository articleRepository;
    @Autowired private CommentRepository commentRepository;

    public void saveArticle(Article article){
        article.setDate(new Date());
        articleRepository.save(article);
    }

    public void deleterArticle(int id){
        articleRepository.delete(id);
    }

    public List<Article> findArticle(){
        return articleRepository.findAll();
    }

    public Article getOneArticle(int id){
        Article one = articleRepository.getOne(id);
        List<Comment> byReportIsFalseAndArticle = commentRepository.findByReportAndArticle(true,one);
        one.setComments(byReportIsFalseAndArticle);
        return one;
    }

    public void updateArticle(Article article){
        articleRepository.saveAndFlush(article);
    }

    public List<Article> getByCategoryID(int cid){
        return articleRepository.findByCategoryId(cid);
    }


    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void backComment(Comment comment) {
        Comment one = commentRepository.findOne(comment.getId());
        // 设置为已回复
        one.setFlag(true);
        // 保存新的回复信息
        comment.setId(null);
        commentRepository.save(comment);
    }

    //文章列表排序

}
