package cn.imust.blog.service;

import cn.imust.blog.entity.Links;
import cn.imust.blog.repository.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LinksService {

    @Autowired private LinksRepository linksRepository;

    public void save(Links links) {
        linksRepository.save(links);
    }

    public void delete(int id){
        linksRepository.delete(id);
    }

    public List<Links> findAll(){
        return linksRepository.findAll();
    }
}
