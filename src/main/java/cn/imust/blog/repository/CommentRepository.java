package cn.imust.blog.repository;

import cn.imust.blog.entity.Article;
import cn.imust.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByReportAndArticle(boolean report , Article article);

}
