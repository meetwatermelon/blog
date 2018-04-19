package cn.imust.blog.repository;

import cn.imust.blog.entity.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends JpaRepository<Links,Integer> {

}
