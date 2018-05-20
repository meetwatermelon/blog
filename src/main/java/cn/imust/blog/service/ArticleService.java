package cn.imust.blog.service;

import cn.imust.blog.entity.Article;
import cn.imust.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleService {
    @Autowired private ArticleRepository articleRepository;

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
        return articleRepository.getOne(id);
    }

    public void updateArticle(Article article){
        articleRepository.saveAndFlush(article);
    }

    public List<Article> getByCategoryID(int cid){
        return articleRepository.findByCategoryId(cid);
    }


}
