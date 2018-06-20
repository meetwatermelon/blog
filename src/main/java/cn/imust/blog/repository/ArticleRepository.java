package cn.imust.blog.repository;

import cn.imust.blog.entity.Article;
import cn.imust.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
    List<Article> findByCategoryId(Integer id);

    List<Article> findByCategory(Category category);
}
