package cn.imust.blog.service;

import cn.imust.blog.entity.Album;
import cn.imust.blog.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlbumService {
    @Autowired private AlbumRepository albumRepository;

    public void save(Album album){
        albumRepository.save(album);
    }

    public void delete(int id){
        albumRepository.delete(id);
    }

    public List<Album> findAll(){
        return albumRepository.findAll();
    }
}
