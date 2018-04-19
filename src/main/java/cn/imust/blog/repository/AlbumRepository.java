package cn.imust.blog.repository;

import cn.imust.blog.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
