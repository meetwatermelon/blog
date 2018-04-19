package cn.imust.blog.repository;

import cn.imust.blog.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser,Integer> {
}
