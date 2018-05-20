package cn.imust.blog.service;

import cn.imust.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired private CategoryRepository categoryRepository;

    public List findAll(){
       return categoryRepository.findAll();
    }
}
