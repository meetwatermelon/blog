package cn.imust.blog.service;

import cn.imust.blog.entity.Album;
import cn.imust.blog.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;

@Service
@Transactional
public class AlbumService {
    @Autowired private AlbumRepository albumRepository;

    public void save(Album album){
        albumRepository.save(album);
    }

    public void delete(int id){
        Album album = albumRepository.findOne(id);
        String name = album.getName();
        name = name.substring(name.lastIndexOf("/") + 1);
        File file = new File("F:\\blog\\album\\" + name);
        file.delete();
        albumRepository.delete(id);
    }

    public List<Album> findAll(){
        return albumRepository.findAll();
    }
}
